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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.jaspersoft.android.jaspermobile.R;
import com.jaspersoft.android.jaspermobile.activities.repository.ResourcesActivity;
import com.jaspersoft.android.sdk.client.oxm.resource.ResourceLookup;
import com.jaspersoft.android.sdk.ui.adapters.ResourceLookupGridAdapter;
import roboguice.inject.InjectView;

import java.util.Comparator;
import java.util.List;

import static android.widget.AdapterView.OnItemClickListener;

/**
 * @author Ivan Gadzhega
 * @since 2.0
 */
public class ResourcesGridFragment extends RoboSherlockFragment implements ResourcesFragment {

    final private OnItemClickListener onClickListener = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            onListItemClick((GridView) parent, v, position, id);
        }
    };

    @InjectView(android.R.id.list)
    private GridView gridView;
    @InjectView(android.R.id.empty)
    private TextView emptyText;

    private ArrayAdapter<ResourceLookup> resourcesAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.resources_grid_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView.setOnItemClickListener(onClickListener);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        registerForContextMenu(gridView);
        ((ResourcesActivity) getActivity()).loadResources(false);
    }

    public void onListItemClick(GridView parent, View view, int position, long id) {
        ResourceLookup resource = (ResourceLookup) parent.getItemAtPosition(position);
        ((ResourcesActivity) getActivity()).onResourceClick(resource);
    }

    //---------------------------------------------------------------------
    // ResourcesFragment
    //---------------------------------------------------------------------

    @Override
    public void initResourcesAdapter(List<ResourceLookup> resourceLookups) {
        initResourcesAdapter(resourceLookups, null);
    }

    @Override
    public void initResourcesAdapter(List<ResourceLookup> resourceLookups, Comparator<ResourceLookup> comparator) {
        ResourceLookupGridAdapter adapter = new ResourceLookupGridAdapter(getActivity(), resourceLookups);
        if (comparator != null) adapter.sort(comparator);
        setResourcesAdapter(adapter);
    }

    @Override
    public void setResourcesAdapter(ArrayAdapter<ResourceLookup> adapter) {
        resourcesAdapter = adapter;
        gridView.setAdapter(adapter);
    }

    @Override
    public ArrayAdapter<ResourceLookup> getResourcesAdapter() {
        return resourcesAdapter;
    }

    @Override
    public AbsListView getResourcesView() {
        return gridView;
    }

    @Override
    public void setEmptyText(CharSequence text) {
        emptyText.setText(text);
        gridView.setEmptyView(emptyText);
    }

    @Override
    public ViewType getViewType() {
        return ViewType.GRID;
    }

}
