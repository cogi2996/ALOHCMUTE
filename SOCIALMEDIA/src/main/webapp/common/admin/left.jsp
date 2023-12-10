<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Vertical Navbar -->
<nav
	class="navbar show navbar-vertical h-lg-screen navbar-expand-lg px-0 py-3 navbar-light bg-white border-bottom border-bottom-lg-0 border-end-lg"
	id="navbarVertical">
	<div class="container-fluid">
		<!-- Toggler -->
		<button class="navbar-toggler ms-n2" type="button"
			data-bs-toggle="collapse" data-bs-target="#sidebarCollapse"
			aria-controls="sidebarCollapse" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- Brand -->
		<a class="navbar-brand py-lg-2 mb-lg-5 px-lg-6 me-0" href="#">
			<h3 class="text-success">
				<img
					src="https://cdn.haitrieu.com/wp-content/uploads/2021/09/Logo-DH-Su-Pham-Ky-Thuat-TP-Ho-Chi-Minh-HCMUTE.png"
					width="40"><span class="text-info">ALO</span>HCMUTE
			</h3>
		</a>
		<!-- Collapse -->
		<div class="collapse navbar-collapse" id="sidebarCollapse">
			<!-- Navigation -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/SOCIALMEDIA/admin-manage/home"> <i
						class="bi bi-house"></i> HOME
				</a></li>

				<li class="nav-item"><a class="nav-link" href="/SOCIALMEDIA/admin-manage/user/listuser"> <i
						class="bi bi-people"></i> USERS
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/SOCIALMEDIA/admin-manage/post/listpost"> <i
						class="bi bi-file-text"></i> POSTS
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/SOCIALMEDIA/admin-manage/group/listgroup"> <i
						class="bi bi-globe-americas"></i> GROUPS
				</a></li>
			</ul>
		</div>
	</div>
</nav>