package com.nobeldhar.blooddonation.di.module

import com.nobeldhar.blooddonation.ui.comments.CommentsFragment
import com.nobeldhar.blooddonation.ui.profile.createpost.CreatePostFragment
import com.nobeldhar.blooddonation.ui.forgotpassword.ForgotPasswordFragment
import com.nobeldhar.blooddonation.ui.gallery.GalleryFragment
import com.nobeldhar.blooddonation.ui.dashboard.DashboardFragment
import com.nobeldhar.blooddonation.ui.dashboard.allposts.AllPostsFragment
import com.nobeldhar.blooddonation.ui.dashboard.group.GroupFragment
import com.nobeldhar.blooddonation.ui.dashboard.members.MembersFragment
import com.nobeldhar.blooddonation.ui.dashboard.topdoner.TopDonorsFragment
import com.nobeldhar.blooddonation.ui.login.LoginFragment
import com.nobeldhar.blooddonation.ui.profile.ProfileFragment
import com.nobeldhar.blooddonation.ui.profile.addhistory.AddHistoryFragment
import com.nobeldhar.blooddonation.ui.profile.donatehistory.DonateHistoryFragment
import com.nobeldhar.blooddonation.ui.register.RegisterFragment
import com.nobeldhar.blooddonation.ui.profile.settings.address.AddressFragment
import com.nobeldhar.blooddonation.ui.profile.settings.basic.BasicFragment
import com.nobeldhar.blooddonation.ui.profile.settings.information.InformationFragment
import com.nobeldhar.blooddonation.ui.profile.settings.password.PasswordFragment
import com.nobeldhar.blooddonation.ui.profile.timeline.TimelineFragment
import com.nobeldhar.blooddonation.ui.reply.ReplyFragment
import com.nobeldhar.blooddonation.ui.slideshow.SlideshowFragment
import com.nobeldhar.blooddonation.ui.splash.SplashFragment
import com.nobeldhar.blooddonation.ui.updatecomment.UpdateComFragment
import com.nobeldhar.blooddonation.ui.verifycode.VerifyCodeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeRegFragment(): RegisterFragment

    @ContributesAndroidInjector
    abstract fun contributeGalFragment(): GalleryFragment

    @ContributesAndroidInjector
    abstract fun contributeSlideFragment(): SlideshowFragment

    @ContributesAndroidInjector
    abstract fun contributeForgotPassFragment(): ForgotPasswordFragment

    @ContributesAndroidInjector
    abstract fun contributeHOmeFragment(): DashboardFragment

    @ContributesAndroidInjector
    abstract fun contributeVerifyFragment(): VerifyCodeFragment

    @ContributesAndroidInjector
    abstract fun contributeBasicFragment(): BasicFragment

    @ContributesAndroidInjector
    abstract fun contributeInformationFragment(): InformationFragment

    @ContributesAndroidInjector
    abstract fun contributeAddressFragment(): AddressFragment

    @ContributesAndroidInjector
    abstract fun contributePasswordFragment(): PasswordFragment

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributeCreatePostFragment(): CreatePostFragment

    @ContributesAndroidInjector
    abstract fun contributeAddHistoryFragment(): AddHistoryFragment

    @ContributesAndroidInjector
    abstract fun contributeTimelineFragment(): TimelineFragment

    @ContributesAndroidInjector
    abstract fun contributeDonateHistoryFragment(): DonateHistoryFragment


    @ContributesAndroidInjector
    abstract fun contributeCommentsFragment(): CommentsFragment

    @ContributesAndroidInjector
    abstract fun contributeReplyFragment(): ReplyFragment

    @ContributesAndroidInjector
    abstract fun contributeUpdateComFragment(): UpdateComFragment

    @ContributesAndroidInjector
    abstract fun contributeAllPostsFragment(): AllPostsFragment


    @ContributesAndroidInjector
    abstract fun contributeMembersFragment(): MembersFragment

    @ContributesAndroidInjector
    abstract fun contributeTopDonorsFragment(): TopDonorsFragment

    @ContributesAndroidInjector
    abstract fun contributeGroupFragment(): GroupFragment

}