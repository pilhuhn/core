/**
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.shell.aesh;

import java.util.Map;

import org.jboss.aesh.cl.ParsedCompleteObject;
import org.jboss.aesh.cl.exception.CommandLineParserException;
import org.jboss.aesh.cl.internal.ParameterInt;
import org.jboss.forge.addon.shell.ui.ShellContext;
import org.jboss.forge.addon.shell.ui.ShellUIBuilderImpl;
import org.jboss.forge.addon.shell.util.ShellUtil;
import org.jboss.forge.addon.ui.UICommand;
import org.jboss.forge.addon.ui.input.InputComponent;
import org.jboss.forge.addon.ui.result.Result;

/**
 * 
 * @author <a href="ggastald@redhat.com">George Gastaldi</a>
 */
public abstract class AbstractShellCommand implements Comparable<AbstractShellCommand>
{
   private final String name;
   private final ShellContext context;
   private final UICommand root;

   protected final CommandLineUtil commandLineUtil;

   protected AbstractShellCommand(UICommand root, ShellContext shellContext,
            CommandLineUtil commandLineUtil)
   {
      this.root = root;
      this.name = ShellUtil.shellifyName(root.getMetadata().getName());
      this.context = shellContext;
      this.commandLineUtil = commandLineUtil;
   }

   public abstract Map<String, InputComponent<?, Object>> getInputs();

   public abstract ParameterInt getParameter();

   public abstract ParsedCompleteObject parseCompleteObject(String line) throws CommandLineParserException;

   public abstract void populateInputs(String line, boolean lenient) throws CommandLineParserException;

   public abstract Result execute() throws Exception;

   protected Map<String, InputComponent<?, Object>> buildInputs(UICommand command)
   {
      // Initialize UICommand
      ShellUIBuilderImpl builder = new ShellUIBuilderImpl(context);
      try
      {
         command.initializeUI(builder);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Error while initializing command", e);
      }
      return builder.getComponentMap();

   }

   public UICommand getSourceCommand()
   {
      return root;
   }

   public final String getName()
   {
      return name;
   }

   public final ShellContext getContext()
   {
      return context;
   }

   @Override
   public int compareTo(AbstractShellCommand o)
   {
      return getName().compareTo(o.getName());
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o)
         return true;
      if (!(o instanceof AbstractShellCommand))
         return false;

      AbstractShellCommand that = (AbstractShellCommand) o;

      if (!getName().equals(that.getName()))
         return false;

      return true;
   }

   @Override
   public int hashCode()
   {
      return getName().hashCode();
   }

   @Override
   public String toString()
   {
      return getName();
   }
}