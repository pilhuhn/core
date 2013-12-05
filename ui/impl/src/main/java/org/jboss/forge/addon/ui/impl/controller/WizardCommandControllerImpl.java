/**
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.ui.impl.controller;

import org.jboss.forge.addon.ui.UICommand;
import org.jboss.forge.addon.ui.context.UIValidationContext;
import org.jboss.forge.addon.ui.controller.WizardCommandController;
import org.jboss.forge.addon.ui.result.Result;
import org.jboss.forge.addon.ui.spi.UIContextFactory;
import org.jboss.forge.addon.ui.wizard.UIWizard;
import org.jboss.forge.furnace.addons.AddonRegistry;

/**
 * 
 * @author <a href="ggastald@redhat.com">George Gastaldi</a>
 */
class WizardCommandControllerImpl extends AbstractCommandController implements WizardCommandController
{

   public WizardCommandControllerImpl(AddonRegistry addonRegistry, UIContextFactory contextFactory,
            UIWizard initialCommand)
   {
      super(addonRegistry, contextFactory, initialCommand);
   }

   @Override
   public UIWizard getInitialCommand()
   {
      return (UIWizard) super.getInitialCommand();
   }

   @Override
   public UICommand getCurrentCommand()
   {
      return null;
   }

   @Override
   public void initialize() throws Exception
   {

   }

   @Override
   public boolean canFlipToNextPage()
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean canFlipToPreviousPage()
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean canExecute()
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public void next() throws IllegalStateException
   {
   }

   @Override
   public void previous() throws IllegalStateException
   {
   }

   @Override
   public void valueChanged()
   {
      // TODO Auto-generated method stub

   }

   /*
    * (non-Javadoc)
    * 
    * @see org.jboss.forge.addon.ui.controller.CommandController#execute()
    */
   @Override
   public Result execute() throws Exception
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public UIValidationContext validate()
   {
      return null;
   }

   @Override
   public boolean isCurrentCommandRenderable()
   {
      // TODO Auto-generated method stub
      return false;
   }

}