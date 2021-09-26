package com.know.androidnew

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.know.androidnew.arch.KooViewModel
import com.know.androidnew.arch.ViewModelFactory
import com.know.androidnew.databinding.ActivityMainBinding
import com.know.androidnew.model.Data
import com.know.androidnew.network.ApiInterface
import com.know.androidnew.network.RetrofitHelper
import com.know.androidnew.repository.UserRepository


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var kooViewModel: KooViewModel
    private lateinit var shimmerLayout: ShimmerFrameLayout
    private var mKooListAdapter: KooAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*Getting View Binding instance from activity_main xml layout
        * all the view defined in the activity_main can be accessed from binding object*/
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mRecyclerView = binding.recycleerView
        shimmerLayout = binding.shimmerLayout
        shimmerLayout.visibility = View.VISIBLE
        shimmerLayout.startShimmer()
        /*Creating instance of Layout Manager*/
        val LinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.layoutManager = LinearLayoutManager;
        /*creating instance of ApiInterface using RetrofitHelper*/
        val apiInterface = RetrofitHelper.getRetrofitInstance().create(ApiInterface::class.java)
        /*creating instance of repository to get the viewModel factory
        * ViewModel factory is reposible for creating ViieqModel instacne with the help of Lifecycle Owner (Activity , Fragment)*/
        val repository = UserRepository(apiInterface)
        kooViewModel =
            ViewModelProvider(this, ViewModelFactory(repository)).get(KooViewModel::class.java)
        kooViewModel.userliveData.observe(this) {
            setAdapter(it.data)
        }


    }

    /*setAdapter() function is reposible for creating instance of KooAdapter
    * with the help of adpater we are showing list of data on the activity
    * */
    private fun setAdapter(list: List<Data>) {
        shimmerLayout.visibility = View.GONE
        shimmerLayout.stopShimmer()
        if (mKooListAdapter == null) {
            mKooListAdapter = KooAdapter(list!!, this)
            mRecyclerView!!.adapter = mKooListAdapter

        } else {
            mKooListAdapter!!.notifyDataSetChanged()
        }
    }
}