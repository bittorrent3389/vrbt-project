create table TBL_CATEGORY (
	categoryId LONG not null primary key,
	categoryName VARCHAR(75) null,
	description VARCHAR(75) null,
	status INTEGER
);

create table TBL_CATEGORY_VIDEO (
	categoryViceoId LONG not null primary key,
	categoryId LONG,
	videoId LONG
);

create table TBL_CONTACT (
	contactId LONG not null primary key,
	contactName VARCHAR(75) null,
	mobileNumber VARCHAR(75) null,
	userId LONG
);

create table TBL_CONTACT_GROUP (
	contactGroupId LONG not null primary key,
	contactGroupName VARCHAR(75) null,
	description VARCHAR(75) null,
	contactGroupType INTEGER,
	userId LONG
);

create table TBL_CONTACT_GROUP_CONTACT (
	contactGroupContactId LONG not null primary key,
	contactId VARCHAR(75) null,
	contactGroupId VARCHAR(75) null
);

create table TBL_CONTACT_GROUP_VIDEO_GROUP (
	contactGroupVideoGroupEntryId LONG not null primary key,
	contactGroupId LONG,
	videoGroupId LONG
);

create table TBL_FOLDER (
	folderId LONG not null primary key,
	folderName VARCHAR(75) null,
	description VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	folderIdParent LONG,
	userId LONG
);

create table TBL_NOTIFICATION (
	notificationId LONG not null primary key,
	userIdFrom LONG,
	userIdTo LONG,
	subject VARCHAR(75) null,
	message VARCHAR(75) null,
	createDate DATE null,
	status INTEGER
);

create table TBL_RATING (
	ratingId LONG not null primary key,
	videoId LONG,
	userId LONG,
	code INTEGER,
	date_ DATE null
);

create table TBL_SERVICE (
	serviceId LONG not null primary key,
	serviceCode VARCHAR(75) null,
	serviceName VARCHAR(75) null,
	description VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER
);

create table TBL_SERVICE_PACKAGE (
	servicePackageId LONG not null primary key,
	servicePackageName VARCHAR(75) null,
	servicePackageCode VARCHAR(75) null,
	description VARCHAR(75) null,
	totalFile INTEGER,
	createDate DATE null,
	modifiedDate DATE null,
	serviceId LONG,
	status INTEGER
);

create table TBL_SERVICE_TRANSACTION (
	transactionId LONG not null primary key,
	transactionCode INTEGER,
	date_ DATE null,
	userId LONG,
	serviceId LONG,
	serviceStatus INTEGER,
	serviceStartDate DATE null,
	serviceStopDate DATE null,
	servicePackageId LONG,
	packageDate DATE null
);

create table TBL_USER (
	userId LONG not null primary key,
	userName VARCHAR(75) null,
	mobileNumber VARCHAR(75) null,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER
);

create table TBL_USER_SERVICE (
	userServiceId LONG not null primary key,
	userId LONG,
	serviceId LONG,
	serviceStatus INTEGER,
	serviceStartDate DATE null,
	serviceStopDate DATE null,
	servicePackageId LONG,
	packageDate DATE null
);

create table TBL_VIDEO (
	videoId LONG not null primary key,
	videoName VARCHAR(75) null,
	videoUrl VARCHAR(75) null,
	description VARCHAR(75) null,
	viewCount LONG,
	date_ DATE null,
	smallImageUrl VARCHAR(75) null,
	largeImageUrl VARCHAR(75) null,
	accessModifier INTEGER,
	uploaderId LONG,
	folderId LONG,
	status INTEGER
);

create table TBL_VIDEO_GROUP (
	videoGroupId LONG not null primary key,
	videoGroupName VARCHAR(75) null,
	description VARCHAR(75) null
);

create table TBL_VIDEO_USER (
	videoUserId LONG not null primary key,
	videoId LONG,
	userId LONG,
	originCode INTEGER,
	date_ DATE null,
	startDate DATE null,
	endDate DATE null,
	senderId LONG,
	status INTEGER
);

create table TBL_VIDEO_USER_CONTACT (
	videoUserContactId LONG not null primary key,
	videoUserId LONG,
	contactId LONG,
	companyId LONG,
	startTime DATE null,
	endTime DATE null,
	priority INTEGER,
	status INTEGER
);

create table TBL_VIDEO_USER_TRANSACTION (
	transactionId LONG not null primary key,
	transactionCode LONG,
	date_ DATE null,
	videoId LONG,
	userId LONG,
	receiverId LONG
);

create table TBL_VIDEO_USER_VIDEO_GROUP (
	videoUserVideoGroupID LONG not null primary key,
	videoUserId LONG,
	videoGroupId LONG
);

create table TBL_VIOLATION (
	violationId LONG not null primary key,
	violationTitle VARCHAR(75) null,
	description VARCHAR(75) null,
	status INTEGER
);

create table TBL_VIOLATION_VIDEO (
	violationVideoId LONG not null primary key,
	violationId LONG,
	videoId LONG,
	userId LONG,
	date_ DATE null,
	description VARCHAR(75) null
);