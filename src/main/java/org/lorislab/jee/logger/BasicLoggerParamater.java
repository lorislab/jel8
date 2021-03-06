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

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * The basic log parameter.
 *
 * @author Andrej Petras
 */
@Named
@ApplicationScoped
public class BasicLoggerParamater extends LoggerParameter {

    /**
     * {@inheritDoc}
     */
    @Override
    public Class[] getClasses() {
        return new Class[] { 
            Class.class, 
            byte.class,
            int.class, 
            double.class,
            float.class,
            boolean.class,
            long.class,
            Integer.class,
            Double.class,
            String.class,
            Boolean.class,
            Long.class,
            Byte.class
        };        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getObject(Object parameter) {
        return "" + parameter;
    }
}
