<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="card m-b-30">
	<div class="card-header bg-white">
		<h5 class="card-title text-black mb-0">Social Profile</h5>
	</div>
	<div class="card-body">
		<div class="xp-social-profile">
			<div class="xp-social-profile-top">
				<div class="row">
					<div class="col-3">
						<div class="xp-social-profile-star py-3">
							<i class="mdi mdi-star font-24"></i>
						</div>
					</div>
					<div class="col-6">
						<div class="xp-social-profile-avatar text-center">
							<img src="https://bootdey.com/img/Content/avatar/avatar6.png"
								alt="user-profile" class="rounded-circle img-fluid"> <span
								class="xp-social-profile-live"></span>
						</div>
					</div>
					<div class="col-3">
						<div class="xp-social-profile-menu text-right py-3">
							<i class="mdi mdi-dots-horizontal font-24"></i>
						</div>
					</div>
				</div>
			</div>
			<div class="xp-social-profile-middle text-center">
				<div class="row">
					<div class="col-12">
						<div class="xp-social-profile-title">
							<h5 class="my-1 text-black">${user.getLastName() }
								${user.getMidName() } ${user.getFirstName() }</h5>
						</div>
						<div class="xp-social-profile-desc">
							<p class="text-muted">${user.getBiography() }</p>
						</div>
					</div>
				</div>
			</div>
			<div class="xp-social-profile-bottom text-center">
				<div class="row">
					<div class="col-4">
						<div class="xp-social-profile-media pt-3">
							<h5 class="text-black my-1">${countFollower}</h5>
							<p class="mb-0 text-muted"><a href="follower?id=${user.getUserID()}">Followers</a></p>
						</div>
					</div>
					<div class="col-4">
						<div class="xp-social-profile-followers pt-3">
							<h5 class="text-black my-1">${countFollowing }</h5>
							<p class="mb-0 text-muted"><a href="following?id=${user.getUserID()}">Following</a></p>
						</div>
					</div>
					<div class="col-4">
						<div class="xp-social-profile-following pt-3">
							<h5 class="text-black my-1">${countPost}</h5>
							<p class="mb-0 text-muted"><a href="post?id=${user.getUserID()}">Posts</a></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>