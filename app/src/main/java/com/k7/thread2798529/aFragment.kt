package com.k7.thread2798529

import android.content.Context
import android.graphics.Insets.add
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [aFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class aFragment : Fragment(),RVAdapter.OnItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var recycler: RecyclerView? = null
    private val movieAdapter:RVAdapter = RVAdapter(this)
    var listString= listOf("Открыть фрагмент b",
        "Открыть фрагмент c",
        "Открыть фрагмент b",
        "Открыть фрагмент c",
        "Открыть фрагмент b",
        "Открыть фрагмент c",
        "Открыть фрагмент c"

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler=view.findViewById(R.id.rvForList)
        movieAdapter.setData(listString)
        recycler?.adapter=movieAdapter



    }

    override fun onItemClick(data: String) {
      if (data=="Открыть фрагмент b"){
          requireActivity().supportFragmentManager.beginTransaction().apply {
              addToBackStack(null)
              add(R.id.Fragment_container_Main, bFragment.newInstance())
              commit()
          }
      }
        if (data=="Открыть фрагмент c"){
            requireActivity().supportFragmentManager.beginTransaction().apply {
                addToBackStack(null)
                add(R.id.Fragment_container_Main, cFragment.newInstance())
                commit()
            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment aFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            aFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}