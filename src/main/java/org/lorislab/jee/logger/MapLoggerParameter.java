/*
 * Copyright 2012 Andrej Petras <andrej@ajka-andrej.com>.
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
package org.lorislab.jee.logger;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;
import java.util.Map.Entry;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * The map instances log parameter.
 *
 * @author Andrej Petras
 */
@Named
@ApplicationScoped
public class MapLoggerParameter extends LoggerParameter {

    @Override
    public Class getAssignableFrom() {
        return Map.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getObject(Object parameter) {
        StringBuilder sb = new StringBuilder();

        String name = parameter.getClass().getSimpleName();
        Map<?, ?> tmp = (Map<?, ?>) parameter;

        if (tmp.isEmpty()) {
            sb.append("empty ").append(name);
        } else {
            sb.append(name).append(' ').append(tmp.size()).append(" of [");

            String keyClassName = null;
            String valueClassName = null;

            if (parameter.getClass().getGenericSuperclass() instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) parameter.getClass().getGenericSuperclass();
                
                Type keyType = parameterizedType.getActualTypeArguments()[0];
                if (!(keyType instanceof TypeVariable)) {
                    keyClassName = keyType.getClass().getSimpleName();
                }
                
                Type valueType = parameterizedType.getActualTypeArguments()[1];
                if (!(valueType instanceof TypeVariable)) {
                    keyClassName = valueType.getClass().getSimpleName();
                }                
            }

                Entry<?, ?> item = tmp.entrySet().iterator().next();
                // get key class name
                if (keyClassName == null && item.getKey() != null) {
                    keyClassName = item.getKey().getClass().getSimpleName();
                }
                // get value class name
                if (item.getValue() != null) {
                    valueClassName = item.getValue().getClass().getSimpleName();
                }
            sb.append(keyClassName).append('+').append(valueClassName).append(']');
        }
        return sb.toString();
    }
}
