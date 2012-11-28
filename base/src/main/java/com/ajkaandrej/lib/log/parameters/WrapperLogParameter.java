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
package com.ajkaandrej.lib.log.parameters;

import com.ajkaandrej.lib.ejb.wrapper.AbstractWrapper;
import com.ajkaandrej.log.parameters.InstanceOfLogParameter;

/**
 * The wrapper log service parameter.
 * 
 * @author Andrej Petras <andrej@ajka-andrej.com>
 */
public class WrapperLogParameter implements InstanceOfLogParameter {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean instanceOfClasses(Object parameter) {
        return parameter instanceof AbstractWrapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isResult() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getObject(Object parameter) {
        AbstractWrapper wrapper = (AbstractWrapper) parameter;
        return parameter.getClass().getSimpleName() + ":" + wrapper.getGuid();
    }
}
