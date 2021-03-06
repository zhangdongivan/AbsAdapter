/*
 * Copyright (C) 2016 AriaLyy(AbsAdapter)
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
package com.arialyy.absadapter.delegate;

import android.content.Context;

import java.util.List;

/**
 * Created by lyy on 2016/7/6.
 */
public interface AbsIAdapter<T extends AbsDEntity> {

    /**
     * get manager
     */
    public AbsDManager getManager();

    /**
     * get list data
     *
     * @return
     */
    public List<T> getData();

    /**
     * get context
     *
     * @return
     */
    public Context getContext();
}
