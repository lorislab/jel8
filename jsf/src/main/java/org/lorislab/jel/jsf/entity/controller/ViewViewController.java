/*
 * Copyright 2014 lorislab.org.
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
package org.lorislab.jel.jsf.entity.controller;

import org.lorislab.jel.jsf.view.controller.ViewController;

/**
 * The open view controller.
 *
 * @author Andrej Petras
 */
public interface ViewViewController extends ViewController {

    /**
     * Open to view the entity.
     *
     * @param guid the entity GUID.
     * @return the navigation path.
     * @throws java.lang.Exception if the method fails.
     */
    public Object view(String guid) throws Exception;
}
