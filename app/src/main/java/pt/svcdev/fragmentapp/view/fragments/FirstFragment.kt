package pt.svcdev.fragmentapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_first.*
import pt.svcdev.fragmentapp.R
import pt.svcdev.fragmentapp.repository.ClassesRepositoryImpl
import pt.svcdev.fragmentapp.repository.HomeworkRepositoryImpl
import pt.svcdev.fragmentapp.view.ClassesState
import pt.svcdev.fragmentapp.view.HomeworkState
import pt.svcdev.fragmentapp.view.adapter.ClassesRVAdapter
import pt.svcdev.fragmentapp.view.adapter.HomeworkRVAdapter
import pt.svcdev.fragmentapp.viewmodel.FirstFragmentClassesViewModel
import pt.svcdev.fragmentapp.viewmodel.FirstFragmentHomeworkViewModel

class FirstFragment : Fragment() {
    private val classesViewModel: FirstFragmentClassesViewModel by lazy {
        FirstFragmentClassesViewModel(ClassesRepositoryImpl())
    }

    private val homeworkViewModel: FirstFragmentHomeworkViewModel by lazy {
        FirstFragmentHomeworkViewModel(HomeworkRepositoryImpl())
    }
    private val classesRVAdapter: ClassesRVAdapter by lazy { ClassesRVAdapter() }
    private val homeworkRVAdapter: HomeworkRVAdapter by lazy { HomeworkRVAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initView()
        classesViewModel.getData()
        homeworkViewModel.getData()
    }

    private fun initView() {
        val classesLinearLayoutManager = LinearLayoutManager(context)
        classesLinearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        rv_classes.layoutManager = classesLinearLayoutManager
        rv_classes.adapter = classesRVAdapter
        val homeworkLinearLayoutManager = LinearLayoutManager(context)
        homeworkLinearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        rv_homework.layoutManager = homeworkLinearLayoutManager
        rv_homework.adapter = homeworkRVAdapter
    }

    private fun initViewModel() {
        classesViewModel.subscribe().observe(viewLifecycleOwner) {
            onClassesStateChanged(it)
        }
        homeworkViewModel.subscribe().observe(viewLifecycleOwner) {
            onHomeworkStateChanged(it)
        }
    }

    private fun onClassesStateChanged(screenState: ClassesState?) {
        when (screenState) {
            is ClassesState.Success -> {
                classesRVAdapter.setData(screenState.result)
            }
            is ClassesState.Error -> {
                Toast.makeText(context, screenState.error.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onHomeworkStateChanged(screenState: HomeworkState?) {
        when (screenState) {
            is HomeworkState.Success -> {
                homeworkRVAdapter.setData(screenState.result)
            }
            is HomeworkState.Error -> {
                Toast.makeText(context, screenState.error.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}