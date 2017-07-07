package com.example.manjushachava.foodapp;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Parent> parentList;
    private ArrayList<Parent> originalList;


    /**
     * Constructor that accepts a context, list of strings, and hashMaps of strings
     *
     * @param context
     * @param parentArrayList
     */
    public ExpandableListAdapter(Context context, ArrayList<Parent> parentArrayList) {
        this.context = context;
        this.parentList = new ArrayList<Parent>();
        this.parentList.addAll(parentArrayList);
        this.originalList = new ArrayList<Parent>();
        this.originalList.addAll(parentArrayList);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<Child> countryList = parentList.get(groupPosition).getChildList();
        return countryList.get(childPosition);
    }

    /**
     * Gets the child id at the child position
     *
     * @param groupPosition
     * @param childPosition
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /**
     * Gets the child view at positions
     *
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param view
     * @param parent
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View view, ViewGroup parent) {

        Child child = (Child) getChild(groupPosition, childPosition);
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_item, null);
        }

        TextView name = (TextView) view.findViewById(R.id.lblListItem);
        name.setText(child.getName().trim());
        return view;
    }

    /**
     * Gets the child count based on group position
     *
     * @param groupPosition
     */
    @Override
    public int getChildrenCount(int groupPosition) {

        ArrayList<Child> countryList = parentList.get(groupPosition).getChildList();
        return countryList.size();

    }

    /**
     * Gets the group based on group position
     *
     * @param groupPosition
     */
    @Override
    public Object getGroup(int groupPosition) {
        return parentList.get(groupPosition);
    }

    /**
     * @return the group count based on group position
     */
    @Override
    public int getGroupCount() {
        return parentList.size();
    }

    /**
     * @return the group count based on group position
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * Gets the view of the group
     *
     * @param groupPosition
     * @param isLastChild
     * @param view
     * @param parent
     * @return the view
     */
    @Override
    public View getGroupView(int groupPosition, boolean isLastChild, View view,
                             ViewGroup parent) {

        Parent parent1 = (Parent) getGroup(groupPosition);
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_group, null);
        }

        TextView heading = (TextView) view.findViewById(R.id.lblListHeader);
        heading.setText(parent1.getName().trim());

        return view;
    }

    /**
     * Checks if listView has stable id
     *
     * @return false
     */
    @Override
    public boolean hasStableIds() {
        return true;
    }

    /**
     * Checks if the child is selectable at certain positions
     *
     * @param groupPosition
     * @param childPosition
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData(String query) {

        query = query.toLowerCase();
        Log.v("MyListAdapter", String.valueOf(parentList.size()));
        parentList.clear();

        if (query.isEmpty()) {
            parentList.addAll(originalList);
        } else {

            for (Parent parent : originalList) {

                ArrayList<Child> childArrayList = parent.getChildList();
                ArrayList<Child> newList = new ArrayList<Child>();
                for (Child child : childArrayList) {
                    if (child.getName().toLowerCase().contains(query)) {
                        newList.add(child);
                    }
                }
                if (newList.size() > 0) {
                    Parent nParent = new Parent(parent.getName(), newList);
                    parentList.add(nParent);
                }
            }
        }

        notifyDataSetChanged();

    }

}