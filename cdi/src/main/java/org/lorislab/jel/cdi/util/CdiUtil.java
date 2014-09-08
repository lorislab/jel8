/*
 * Copyright 2014 Andrej_Petras.
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
package org.lorislab.jel.cdi.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * The CDI utility class.
 *
 * @author Andrej_Petras
 */
public final class CdiUtil {

    /**
     * The default constructor.
     */
    private CdiUtil() {
        // empty constructor
    }

    /**
     * Gets the bean instance.
     *
     * @param <T> the bean type.
     * @param clazz the class of the bean.
     * @return the bean instance.
     */    
    public static <T> T getBean(Class<T> clazz) {
        BeanManager bm = getBeanManager();
        return getBean(clazz, bm);
    }

    /**
     * Gets the bean instance.
     *
     * @param <T> the bean type.
     * @param clazz the class of the bean.
     * @param bm the bean manager instance.
     * @return the bean instance.
     */
    public static <T> T getBean(Class<T> clazz, BeanManager bm) {
        Bean<T> bean = (Bean<T>) bm.getBeans(clazz).iterator().next();
        CreationalContext<T> ctx = bm.createCreationalContext(bean);
        T result = (T) bm.getReference(bean, clazz, ctx);
        return result;
    }

    /**
     * Gets the bean manager.
     *
     * @return the bean manager.
     */
    public static BeanManager getBeanManager() {
        BeanManager result = null;
        try {
            InitialContext initialContext = new InitialContext();
            result = (BeanManager) initialContext.lookup("java:comp/BeanManager");
        } catch (NamingException ex) {
            Logger.getLogger(CdiUtil.class.getName()).log(Level.SEVERE, "Error lookup the bean manager!", ex);
        }
        return result;
    }

}
