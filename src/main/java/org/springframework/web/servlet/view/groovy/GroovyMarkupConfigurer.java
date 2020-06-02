/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.servlet.view.groovy;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import groovy.text.markup.MarkupTemplateEngine;
import groovy.text.markup.TemplateConfiguration;
import groovy.text.markup.TemplateResolver;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * An extension of Groovy's {@link groovy.text.markup.TemplateConfiguration} and
 * an implementation of Spring MVC's {@link GroovyMarkupConfig} for creating
 * a {@code MarkupTemplateEngine} for use in a web application. The most basic
 * way to configure this class is to set the "resourceLoaderPath". For example:
 *
 * <pre class="code">
 *
 * // Add the following to an &#64;Configuration class
 *
 * &#64;Bean
 * public GroovyMarkupConfig groovyMarkupConfigurer() {
 *     GroovyMarkupConfigurer configurer = new GroovyMarkupConfigurer();
 *     configurer.setResourceLoaderPath("classpath:/WEB-INF/groovymarkup/");
 *     return configurer;
 * }
 * </pre>
 *
 * By default this bean will create a {@link MarkupTemplateEngine} with:
 * <ul>
 * <li>a parent ClassLoader for loading Groovy templates with their references
 * <li>the default configuration in the base class {@link TemplateConfiguration}
 * <li>a {@link groovy.text.markup.TemplateResolver} for resolving template files
 * </ul>
 *
 * You can provide the {@link MarkupTemplateEngine} instance directly to this bean
 * in which case all other properties will not be effectively ignored.
 *
 * <p>This bean must be included in the application context of any application
 * using the Spring MVC {@link GroovyMarkupView} for rendering. It exists purely
 * for the purpose of configuring Groovy's Markup templates. It is not meant to be
 * referenced by application components directly. It implements GroovyMarkupConfig
 * to be found by GroovyMarkupView without depending on a bean name. Each
 * DispatcherServlet can define its own GroovyMarkupConfigurer if desired.
 *
 * <p>Note that resource caching is enabled by default in {@link MarkupTemplateEngine}.
 * Use the {@link #setCacheTemplates(boolean)} to configure that as necessary.

 * <p>Spring's Groovy Markup template support requires Groovy 2.3.1 or higher.
 *
 * @author Brian Clozel
 * @author Rossen Stoyanchev
 * @since 4.1
 * @see GroovyMarkupView
 * @see <a href="http://groovy-lang.org/templating.html#_the_markuptemplateengine">
 *     Groovy Markup Template engine documentation</a>
 */
public class GroovyMarkupConfigurer extends TemplateConfiguration
		implements GroovyMarkupConfig, ApplicationContextAware, InitializingBean {


	@Override
	public void afterPropertiesSet() throws Exception {

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

	}

	@Override
	public MarkupTemplateEngine getTemplateEngine() {
		return null;
	}
}
