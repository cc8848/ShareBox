package com.ecjtu.sharebox.ui.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import com.ecjtu.sharebox.R
import com.ecjtu.sharebox.ui.dialog.FilePickDialog
import com.ecjtu.sharebox.ui.view.FileExpandableListView
import java.io.File

/**
 * Created by KerriGan on 2017/7/16.
 */
class InternetFileExpandableAdapter(expandableListView: FileExpandableListView):
        FileExpandableAdapter(expandableListView){

    override fun initData(holder: FilePickDialog.TabItemHolder?) {
        super.initData(holder)
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var ret=super.getGroupView(groupPosition, isExpanded, convertView, parent)
        ret.findViewById(R.id.select_all).visibility=View.INVISIBLE
        return ret
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var ret=super.getChildView(groupPosition, childPosition, isLastChild, convertView, parent)
        ret.findViewById(R.id.check_box).visibility=View.INVISIBLE
        return ret
    }

    override fun onClick(v: View?) {
        var tag=v?.getTag()
        if(tag!=null && tag is File ){
            var path=(tag as File).absolutePath
            openFile(path)
            return
        }
        super.onClick(v)
    }

    override fun setup(activity: Activity?,title:String) {
        //do nothing
    }
}
