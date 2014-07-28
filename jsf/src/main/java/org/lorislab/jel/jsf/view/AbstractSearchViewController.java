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
package org.lorislab.jel.jsf.view;

import java.io.Serializable;
import java.util.List;
import org.lorislab.jel.base.criteria.AbstractSearchCriteria;

/**
 * The abstract table view controller.
 *
 * @author Andrej Petras <andrej@ajka-andrej.com>
 * @param <T> the model.
 * @param <S> the search criteria.
 */
public abstract class AbstractSearchViewController<T, S extends AbstractSearchCriteria> implements Serializable {

    /**
     * The UID for this class.
     */
    private static final long serialVersionUID = 8552218747873068051L;
    /**
     * The search criteria.
     */
    private S criteria;
    /**
     * The result list.
     */
    private List<T> result;

    /**
     * Sets the search criteria.
     *
     * @param criteria the search criteria.
     */
    protected void setCriteria(S criteria) {
        this.criteria = criteria;
    }

    /**
     * Gets the search criteria.
     *
     * @return the search criteria.
     */
    public S getCriteria() {
        return criteria;
    }

    /**
     * Gets the result list.
     *
     * @return the result list.
     */
    public List<T> getResult() {
        return result;
    }

    /**
     * Search the results.
     *
     * @throws Exception is the method fails.
     */
    public void search() throws Exception {
        result = doSearch();
    }

    /**
     * Resets the results.
     *
     * @throws Exception if the method fails.
     */
    public void reset() throws Exception {
        result = null;
        criteria.reset();
    }

    /**
     * Search method for the result table.
     *
     * @return the result list.
     *
     * @throws Exception if the method fails.
     */
    protected abstract List<T> doSearch() throws Exception;
}