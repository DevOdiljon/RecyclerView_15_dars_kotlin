package com.example.a15_recyclerviewforegroundandbackgroundcellkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.*
import com.example.a15_recyclerviewforegroundandbackgroundcellkotlin.R
import com.example.a15_recyclerviewforegroundandbackgroundcellkotlin.adapter.CustomAdapter
import com.example.a15_recyclerviewforegroundandbackgroundcellkotlin.helper.RecyclerItemTouchHelper
import com.example.a15_recyclerviewforegroundandbackgroundcellkotlin.model.Member
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun refreshAdapter(members: ArrayList<Member>) {
        val adapter = CustomAdapter(members)
        recyclerView.adapter = adapter
    }

    private fun prepareMemberList(): ArrayList<Member> {
        val members = ArrayList<Member>()
        for (i in 0..30 step 1){
            members.add(Member("Odilbek $i", "+998 97 775 17 79"))
        }
        return members
    }

    fun initViews(){
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val itemTouchHelperCallback = RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, object: RecyclerItemTouchHelper.RecyclerItemTouchHelperListner{
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {
                Log.d("@@@", "@@@position " + position)
            }
        })
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView)
    }
}