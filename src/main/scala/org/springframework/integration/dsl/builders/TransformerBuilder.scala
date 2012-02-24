/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.integration.dsl.builders
import org.springframework.beans.factory.support.BeanDefinitionBuilder
import org.springframework.integration.config.ServiceActivatorFactoryBean
import org.springframework.integration.config.TransformerFactoryBean
/**
 * 
 * @author Oleg Zhurakousky
 */
private object TransformerBuilder {

   def build(transformer: Transformer, function:Function2[SimpleEndpoint, BeanDefinitionBuilder, Unit]): BeanDefinitionBuilder = {
     val handlerBuilder = BeanDefinitionBuilder.rootBeanDefinition(classOf[TransformerFactoryBean])
     function.apply(transformer, handlerBuilder)
     handlerBuilder
   }
}