/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.git.gitignore;

import static org.jboss.forge.addon.git.constants.GitConstants.BOILERPLATE_FILE;
import static org.jboss.forge.addon.git.constants.GitConstants.CLONE_LOCATION_KEY;
import static org.jboss.forge.addon.git.constants.GitConstants.REPOSITORY;
import static org.jboss.forge.addon.git.constants.GitConstants.REPOSITORY_KEY;

import java.io.File;

import javax.inject.Inject;

import org.jboss.forge.addon.configuration.Configuration;
import org.jboss.forge.addon.configuration.ConfigurationFactory;

public class GitIgnoreConfig
{

   @Inject
   private ConfigurationFactory configFactory;

   public String defaultRemoteRepository()
   {
      return REPOSITORY;
   }

   public String remoteRepository()
   {
      Configuration user = userConfig();
      if (user.containsKey(REPOSITORY_KEY))
      {
         return user.getString(REPOSITORY_KEY);
      }
      return defaultRemoteRepository();
   }

   public void setRemoteRepository(String repoUrl)
   {
      userConfig().setProperty(REPOSITORY_KEY, repoUrl);
   }

   public File defaultLocalRepository()
   {
      return new File(System.getProperty("user.home") + File.separator + BOILERPLATE_FILE);
   }

   public File localRepository()
   {
      Configuration user = userConfig();
      if (user.containsKey(CLONE_LOCATION_KEY))
      {
         return new File(user.getString(CLONE_LOCATION_KEY));
      }
      return defaultLocalRepository();
   }

   public void setLocalRepository(String location)
   {
      userConfig().setProperty(CLONE_LOCATION_KEY, location);
   }

   private Configuration userConfig()
   {
      return configFactory.getUserConfiguration();
   }

}
