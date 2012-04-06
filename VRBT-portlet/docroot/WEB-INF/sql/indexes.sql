create index IX_1E5C022 on TBL_CATEGORY (categoryName);
create index IX_1EBA966B on TBL_CATEGORY (status);

create index IX_C2884D58 on TBL_CATEGORY_VIDEO (categoryId, videoId);

create index IX_9A1B2F1E on TBL_CONTACT (userId, mobileNumber);

create index IX_418FDDBF on TBL_CONTACT_GROUP (userId);
create index IX_8405A66D on TBL_CONTACT_GROUP (userId, contactGroupId);

create index IX_C39BA933 on TBL_CONTACT_GROUP_CONTACT (contactId, contactGroupId);

create index IX_794F256F on TBL_CONTACT_GROUP_VIDEO_GROUP (contactGroupId);
create index IX_14970C62 on TBL_CONTACT_GROUP_VIDEO_GROUP (contactGroupId, videoGroupId);
create index IX_36085034 on TBL_CONTACT_GROUP_VIDEO_GROUP (videoGroupId);

create index IX_77787B1C on TBL_FOLDER (folderIdParent);
create index IX_C77A5D02 on TBL_FOLDER (folderName);
create index IX_8AB9236F on TBL_FOLDER (userId);

create index IX_F385F5CB on TBL_NOTIFICATION (userIdFrom, userIdTo);

create index IX_813F341E on TBL_RATING (code_);
create index IX_4B93C248 on TBL_RATING (code_, videoId);
create index IX_9F230EBD on TBL_RATING (date_);
create index IX_CA7849DE on TBL_RATING (userId);
create index IX_1A691CBA on TBL_RATING (userId, videoId, code_);
create index IX_C1007782 on TBL_RATING (videoId);
create index IX_8B655C80 on TBL_RATING (videoId, code_);
create index IX_5172DBC on TBL_RATING (videoId, userId);

create index IX_39FDC678 on TBL_SERVICE (serviceCode);
create index IX_4C01E396 on TBL_SERVICE (serviceName);
create index IX_A1C7BAA0 on TBL_SERVICE (status);

create index IX_AB11E0DF on TBL_SERVICE_PACKAGE (serviceId);
create index IX_9B0CD0C5 on TBL_SERVICE_PACKAGE (serviceId, status);
create index IX_9015F2B3 on TBL_SERVICE_PACKAGE (servicePackageCode);
create index IX_A21A0FD1 on TBL_SERVICE_PACKAGE (servicePackageName);
create index IX_ADEAB8C7 on TBL_SERVICE_PACKAGE (status);

create index IX_B65661C8 on TBL_SERVICE_TRANSACTION (date_);
create index IX_DC6AC082 on TBL_SERVICE_TRANSACTION (transactionCode);
create index IX_F86ACE1F on TBL_SERVICE_TRANSACTION (transactionCode, date_);
create index IX_99AF5833 on TBL_SERVICE_TRANSACTION (userId);
create index IX_DE48F59 on TBL_SERVICE_TRANSACTION (userId, transactionCode, date_);

create index IX_CE6E8ED1 on TBL_USER (mobileNumber);
create index IX_B51EB978 on TBL_USER (status);
create index IX_569DD2CC on TBL_USER (userId);
create index IX_2EF1D07C on TBL_USER (userName);

create index IX_56C125FF on TBL_USER_SERVICE (serviceId, serviceStatus);
create index IX_B851E128 on TBL_USER_SERVICE (servicePackageId);
create index IX_729A0CA2 on TBL_USER_SERVICE (userId);
create index IX_8427CC7E on TBL_USER_SERVICE (userId, serviceId);
create index IX_F00677BE on TBL_USER_SERVICE (userId, serviceId, servicePackageId);
create index IX_6A5E76E2 on TBL_USER_SERVICE (userId, servicePackageId);
create index IX_1A6A5515 on TBL_USER_SERVICE (userId, serviceStatus);

create index IX_28846B21 on TBL_VIDEO (date_);
create index IX_C50521D on TBL_VIDEO (uploaderId);
create index IX_391008BA on TBL_VIDEO (uploaderId, folderId);

create index IX_5FAADCC3 on TBL_VIDEO_GROUP (videoGroupName);

create index IX_6398C436 on TBL_VIDEO_USER (userId, videoId);
create index IX_7F426D1C on TBL_VIDEO_USER (userId, videoId, status);

create index IX_796EA3DD on TBL_VIDEO_USER_CONTACT (contactId, videoUserId);

create index IX_995361CC on TBL_VIDEO_USER_TRANSACTION (date_);
create index IX_F1477153 on TBL_VIDEO_USER_TRANSACTION (receiverId);
create index IX_3ABA8B86 on TBL_VIDEO_USER_TRANSACTION (transactionCode);
create index IX_E155569B on TBL_VIDEO_USER_TRANSACTION (transactionCode, date_);
create index IX_165258AF on TBL_VIDEO_USER_TRANSACTION (userId);
create index IX_F06842D1 on TBL_VIDEO_USER_TRANSACTION (videoId);

create index IX_40D30DD2 on TBL_VIDEO_USER_VIDEO_GROUP (videoUserId, videoGroupId);

create index IX_6A9A2150 on TBL_VIOLATION (status);
create index IX_E9F21951 on TBL_VIOLATION (violationTitle);

create index IX_57291DA on TBL_VIOLATION_VIDEO (videoId, userId);
create index IX_81732DB6 on TBL_VIOLATION_VIDEO (videoId, userId, violationId);