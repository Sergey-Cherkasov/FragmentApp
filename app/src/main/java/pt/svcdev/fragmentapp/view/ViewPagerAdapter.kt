package pt.svcdev.fragmentapp.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import pt.svcdev.fragmentapp.view.fragments.FirstFragment
import pt.svcdev.fragmentapp.view.fragments.SecondFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager){

    private val fragments = listOf(FirstFragment(), SecondFragment())

    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment =
        when(position) {
            FRAGMENT_FIRST -> fragments[FRAGMENT_FIRST]
            FRAGMENT_SECOND -> fragments[FRAGMENT_SECOND]
            else -> fragments[FRAGMENT_FIRST]
        }

    override fun getPageTitle(position: Int): CharSequence {
        return when(position) {
            FRAGMENT_FIRST -> "First fragment"
            FRAGMENT_SECOND -> "Second fragment"
            else -> "First fragment"
        }
    }

    companion object {
        private const val FRAGMENT_FIRST = 0
        private const val FRAGMENT_SECOND = 1
    }
}