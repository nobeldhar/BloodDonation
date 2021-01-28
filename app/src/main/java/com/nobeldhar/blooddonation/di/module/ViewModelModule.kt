package com.nobeldhar.blooddonation.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nobeldhar.blooddonation.factory.AppViewModelFactory
import com.nobeldhar.blooddonation.ui.login.LoginViewModel
import com.nobeldhar.blooddonation.ui.register.RegisterViewModel
import com.nobeldhar.blooddonation.di.util.ViewModelKey
import com.nobeldhar.blooddonation.ui.OneMinuteHelpViewModel
import com.nobeldhar.blooddonation.ui.comments.CommentsViewModel
import com.nobeldhar.blooddonation.ui.forgotpassword.ForgotPasswordViewModel
import com.nobeldhar.blooddonation.ui.dashboard.DashboardViewModel
import com.nobeldhar.blooddonation.ui.dashboard.allposts.AllPostsViewModel
import com.nobeldhar.blooddonation.ui.dashboard.group.GroupViewModel
import com.nobeldhar.blooddonation.ui.profile.ProfileViewModel
import com.nobeldhar.blooddonation.ui.profile.addhistory.AddHistoryViewModel
import com.nobeldhar.blooddonation.ui.profile.createpost.CreatePostViewModel
import com.nobeldhar.blooddonation.ui.profile.donatehistory.DonateHistoryViewModel
import com.nobeldhar.blooddonation.ui.dashboard.members.MembersViewModel
import com.nobeldhar.blooddonation.ui.dashboard.topdoner.TopDonorsViewModel
import com.nobeldhar.blooddonation.ui.profile.settings.address.AddressViewModel
import com.nobeldhar.blooddonation.ui.profile.settings.basic.BasicViewModel
import com.nobeldhar.blooddonation.ui.profile.settings.information.InformationViewModel
import com.nobeldhar.blooddonation.ui.profile.settings.password.PasswordViewModel
import com.nobeldhar.blooddonation.ui.profile.timeline.TimelineViewModel
import com.nobeldhar.blooddonation.ui.reply.ReplyViewModel
import com.nobeldhar.blooddonation.ui.updatecomment.UpdateComViewModel
import com.nobeldhar.blooddonation.ui.verifycode.VerifyCodeViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun bindRegisterViewModel(registerViewModel: RegisterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ForgotPasswordViewModel::class)
    abstract fun bindForgotPassViewModel(forgotPasswordViewModel: ForgotPasswordViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BasicViewModel::class)
    abstract fun bindBasicViewModel(forgotPasswordViewModel: BasicViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(InformationViewModel::class)
    abstract fun bindInformationViewModel(forgotPasswordViewModel: InformationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddressViewModel::class)
    abstract fun bindAddressViewModel(forgotPasswordViewModel: AddressViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PasswordViewModel::class)
    abstract fun bindPasswordViewModel(forgotPasswordViewModel: PasswordViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(VerifyCodeViewModel::class)
    abstract fun bindVerifyCodeViewModel(forgotPasswordViewModel: VerifyCodeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: DashboardViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OneMinuteHelpViewModel::class)
    abstract fun bindOneMinuteHelpViewModel(oneMinuteHelpViewModel: OneMinuteHelpViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreatePostViewModel::class)
    abstract fun bindCreatePostViewModel(createPostViewModel: CreatePostViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddHistoryViewModel::class)
    abstract fun bindAddHistoryViewModel(addHistoryViewModel: AddHistoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TimelineViewModel::class)
    abstract fun bindTimelineViewModel(timelineViewModel: TimelineViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DonateHistoryViewModel::class)
    abstract fun bindDonateHistoryViewModel(donateHistoryViewModel: DonateHistoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CommentsViewModel::class)
    abstract fun bindCommentsViewModel(commentsViewModel: CommentsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ReplyViewModel::class)
    abstract fun bindReplyViewModel(replyViewModel: ReplyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UpdateComViewModel::class)
    abstract fun bindUpdateComViewModel(updateComViewModel: UpdateComViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MembersViewModel::class)
    abstract fun bindMembersViewModel(membersViewModel: MembersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AllPostsViewModel::class)
    abstract fun bindAllPostsViewModel(allPostsViewModel: AllPostsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TopDonorsViewModel::class)
    abstract fun bindTopDonorsViewModel(topDonorsViewModel: TopDonorsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GroupViewModel::class)
    abstract fun bindGroupViewModel(groupViewModel: GroupViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

}