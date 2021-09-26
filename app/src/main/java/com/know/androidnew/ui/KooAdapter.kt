package com.know.androidnew

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.know.androidnew.databinding.KooItemBinding
import com.know.androidnew.model.Data
/*Adapter class to show the list on RecyclerView*/
class KooAdapter (koodata: List<Data>, activity: MainActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mKoodata: List<Data>
    private var mainActivity: MainActivity
    init {
        this.mKoodata=koodata
        this.mainActivity=activity
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.koo_item, parent, false)
        return KooVirwHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder as KooVirwHolder){
            with(mKoodata[position]){
                binding!!.firstname.text= title
                binding!!.secondname.text= body
            }
        }
    }

    override fun getItemCount(): Int {
     return mKoodata.size;
    }
}

class KooVirwHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
    /*View Binding object from KooItemBinding using koo_item.xml */
    val binding = KooItemBinding.bind(view!!)

}
