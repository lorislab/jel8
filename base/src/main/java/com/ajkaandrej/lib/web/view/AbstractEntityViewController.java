/*
 * Copyright 2011 Andrej Petras <andrej@ajka-andrej.com>.
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
package com.ajkaandrej.lib.web.view;

import java.io.Serializable;

/**
 * The abstract entity view controller.
 *
 * @author Andrej Petras <andrej@ajka-andrej.com>
 */
public class AbstractEntityViewController<T> implements Serializable {

    /**
     * The UID for this class.
     */
    private static final long serialVersionUID = 2085181065161645149L;
    /**
     * The model.
     */
    protected T model;

    /**
     * Gets the model.
     *
     * @return the model.
     */
    public T getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param model the model.
     */
    public void setModel(T model) {
        this.model = model;
    }

    /**
     * Reset the view controller.
     */
    public void reset() {
        model = null;
    }

    /**
     * Returns
     * <code>true</code> if the model is
     * <code>null</code>.
     *
     * @return <code>true</code> if the model is <code>null</code>.
     */
    public boolean isEmpty() {
        return model == null;
    }
}