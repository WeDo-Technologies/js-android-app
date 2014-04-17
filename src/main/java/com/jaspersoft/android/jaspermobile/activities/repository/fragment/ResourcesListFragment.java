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

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockListFragment;
import com.jaspersoft.android.sdk.client.oxm.resource.ResourceLookup;

/**
 * @author Ivan Gadzhega
 * @since 2.0
 */
public class ResourcesListFragment extends RoboSherlockListFragment {

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        registerForContextMenu(getListView());
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        ResourceLookup resource = (ResourceLookup) getListView().getItemAtPosition(position);
        ((OnResourceClickListener) getActivity()).onResourceClick(resource);
    }

    //---------------------------------------------------------------------
    // Interfaces
    //---------------------------------------------------------------------

    public interface OnResourceClickListener {
        public void onResourceClick(ResourceLookup resource);
    }

}
