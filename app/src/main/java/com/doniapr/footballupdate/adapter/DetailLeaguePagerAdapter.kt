package com.doniapr.footballupdate.adapter

import android.content.Context
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.doniapr.footballupdate.R
import com.doniapr.footballupdate.view.LastMatchFragment
import com.doniapr.footballupdate.view.NextMatchFragment

class DetailLeaguePagerAdapter(
    private val context: Context,
    fm: FragmentManager,
    private val leagueId: Int
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private val TAB_TITLES = intArrayOf(R.string.tab_text_1, R.string.tab_text_2)

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = LastMatchFragment(leagueId)
            1 -> fragment = NextMatchFragment(leagueId)
        }

        return fragment as Fragment
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }

}