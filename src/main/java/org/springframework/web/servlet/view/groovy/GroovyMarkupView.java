/*
 * Copyright 2002-2017 the original author or authors.
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

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Template;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextException;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.web.servlet.view.AbstractTemplateView;
import org.springframework.web.util.NestedServletException;

/**
 * An {@link AbstractTemplateView} subclass based on Groovy XML/XHTML markup templates.
 *
 * <p>Spring's Groovy Markup Template support requires Groovy 2.3.1 and higher.
 *
 * @author Brian Clozel
 * @author Rossen Stoyanchev
 * @since 4.1
 * @see GroovyMarkupViewResolver
 * @see GroovyMarkupConfigurer
 * @see <a href="http://groovy-lang.org/templating.html#_the_markuptemplateengine">
 * Groovy Markup Template engine documentation</a>
 */
public class GroovyMarkupView extends AbstractTemplateView {

	@Override
	protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

	}
}
