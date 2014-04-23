/*
 * Copyright (C) 2012-2014 Jaspersoft Corporation. All rights reserved.
 * http://community.jaspersoft.com/project/jaspermobile-android
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of Jaspersoft Mobile for Android.
 *
 * Jaspersoft Mobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Jaspersoft Mobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Jaspersoft Mobile for Android. If not, see
 * <http://www.gnu.org/licenses/lgpl>.
 */

package com.jaspersoft.android.jaspermobile.activities.repository.fragment;

import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import com.jaspersoft.android.sdk.client.oxm.resource.ResourceLookup;

import java.util.Comparator;
import java.util.List;

/**
 * @author Ivan Gadzhega
 * @since 2.0
 */
public interface ResourcesFragment {

    public enum ViewType {
        LIST, GRID
    }

    public void initResourcesAdapter(List<ResourceLookup> resourceLookups);

    public void initResourcesAdapter(List<ResourceLookup> resourceLookups, Comparator<ResourceLookup> comparator);

    public void setResourcesAdapter(ArrayAdapter<ResourceLookup> adapter);

    public ArrayAdapter<ResourceLookup> getResourcesAdapter();

    public AbsListView getResourcesView();

    public void setEmptyText(CharSequence text);

    public ViewType getViewType();

}
