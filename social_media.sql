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
    followStatus boolean default 1,
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

-- --Tạo bảng Chat
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
    -- thêm tạm thời groupid
    groupID int null,
    userID varchar(100),
    userPostText nvarchar(5000) not null,
    UserPostCreateTime datetime not null,
    UserPostStatus boolean not null default 1,
    userPostUpdateTime datetime,
    userPostImage nvarchar(1000),
	foreign key (userID) references `User`(userID) on delete cascade,
-- thêm tạm thời
    foreign key (groupID) references `Group`(groupID) on delete cascade
);

-- Tạo bảng GroupPost
-- create table `GroupPost`(
-- 	groupPostID int primary key auto_increment,
--     groupPostText nvarchar(5000) not null,
--     groupPostCreateTime datetime not null,
--     groupPostStatus boolean not null default 1,
--     groupPostUpdateTime datetime not null,
-- 	image nvarchar(100) 
-- );

-- Tạo bảng GroupMember
create table `GroupMember`(
	groupID int,
    userID varchar(100),
--    groupPostID int,
    permission int,
    primary key(groupID, userID),
	foreign key (groupID) references `Group`(groupID) on delete cascade,
	foreign key (userID) references `User`(userID) 
);

CREATE TABLE IF NOT EXISTS `alohcmute`.`hiringpost` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company` VARCHAR(255) NULL DEFAULT NULL,
  `salary` INT NULL DEFAULT NULL,
  `position` VARCHAR(255) NULL DEFAULT NULL,
  `location` VARCHAR(255) NULL DEFAULT NULL,
  `startDate` DATE NULL DEFAULT NULL,
  `endDate` DATE NULL DEFAULT NULL,
  `description` VARCHAR(5000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `alohcmute`.`hiringpost` 
(`company`, `salary`, `position`, `location`, `startDate`, `endDate`, `description`) 
VALUES 
('Công ty A ', '20000', 'Backend', 'Hồ Chí Minh', '2023-11-8', '2023-12-8', 'Không'),
('Công ty B ', '20000', 'Backend', 'Hồ Chí Minh', '2023-11-8', '2023-12-8', 'Không'),
('Công ty C ', '20000', 'Backend', 'Hồ Chí Minh', '2023-11-8', '2023-12-8', 'Không'),
('Công ty D ', '20000', 'Backend', 'Hồ Chí Minh', '2023-11-8', '2023-12-8', 'Không'),
('Công ty E ', '20000', 'Backend', 'Hồ Chí Minh', '2023-11-8', '2023-12-8', 'Không');


CREATE TABLE LikeUserPost (
    userID varchar(100),
    userPostID int,
    likeTime datetime,
    PRIMARY KEY (userID, userPostID),
    FOREIGN KEY (userID) REFERENCES `User`(userID) ON DELETE CASCADE,
    FOREIGN KEY (userPostID) REFERENCES `UserPost`(userPostID) ON DELETE CASCADE
);


-- Nhóm 1
INSERT INTO `Group` (groupName, createTime, createrID)
VALUES ('Nhóm A', '2023-12-09 10:00:00', 'Tu0vC4JFm9TViVIpqSPgxEp3DP92');

-- Nhóm 2
INSERT INTO `Group` (groupName, createTime, createrID)
VALUES ('Nhóm B', '2023-12-09 11:30:00', 'userID_2');

-- Nhóm 3
INSERT INTO `Group` (groupName, createTime, createrID)
VALUES ('Nhóm C', '2023-12-09 13:45:00', 'userID_3');



