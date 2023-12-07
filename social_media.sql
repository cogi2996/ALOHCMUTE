create database ALOHCMUTE;
use ALOHCMUTE;

-- Tạo bảng User 
create table `User`(
	userID varchar(100) primary key,
	mobile varchar(11),
    createDate datetime not null,
    lastLogin datetime ,
    firstName nvarchar(50) not null,
    midName nvarchar(50),
    lastName nvarchar(50) not null,
    address nvarchar(200),
    biography nvarchar(3000),
    position nvarchar(100),
    workPlace nvarchar(200),
    avatar text, 
    role int default 0
  
);



-- Tạo bảng Group
create table `Group`(
	groupID int primary key auto_increment,
    groupName nvarchar(100) not null,
    createTime datetime not null,
    createrID varchar(100),
    foreign key (createrID) references `User`(userID) on delete cascade
);

-- Tạo bảng Follow
create table `Follow`(
	sourceID varchar(100) ,
    targetID varchar(100),
    followCreateTime datetime not null,
    followUpdateTime datetime not null,
    followStatus boolean not null default 1,
    primary key (sourceID, targetID),
    foreign key (sourceID) references `User`(userID) ,
    foreign key (targetID) references `User`(userID)
);

-- Tạo bảng BoxChat
-- create table `BoxChat`(
-- 	boxChatID int primary key auto_increment,
--     userID varchar(100),
--     foreign key (userID) references `User`(userID) 
-- );

-- Tạo bảng Chat
create table `Chat`(
	sourceID varchar(100) ,
    targetID varchar(100),
     primary key (sourceID, targetID),
     foreign key (sourceID) references `User`(userID) ,
    foreign key (targetID) references `User`(userID)
); 

-- Tạo bảng UserPost
create table `UserPost`(
	userPostID int primary key auto_increment,
    userID varchar(100),
    userPostText nvarchar(5000) not null,
    UserPostCreateTime datetime not null,
    UserPostStatus boolean not null default 1,
    userPostUpdateTime datetime,
    userPostImage nvarchar(1000),
	foreign key (userID) references `User`(userID) on delete cascade
);

-- Tạo bảng GroupPost
create table `GroupPost`(
	groupPostID int primary key auto_increment,
    groupPostText nvarchar(5000) not null,
    groupPostCreateTime datetime not null,
    groupPostStatus boolean not null default 1,
    groupPostUpdateTime datetime not null,
	image nvarchar(100) 
);

-- Tạo bảng GroupMember
create table `GroupMember`(
	groupID int,
    userID varchar(100),
    groupPostID int,
    permission int,
    primary key(groupID, userID, groupPostID),
	foreign key (groupID) references `Group`(groupID) on delete cascade,
	foreign key (userID) references `User`(userID) ,
    foreign key (groupPostID) references `GroupPost`(groupPostID) on delete cascade
);



