package com.sample.adaptor.util;

public class Constants {
	public static String METADATA_TMP_FILE_LOCATION = "tmpfilename";
	public static String METADATA_FILE_NAME = "name";
	public static String METADATA_FILE_SIZE = "size";
	public static String ENCRYPTION_KEY_NAME = "key";
	public static String SIMPLEDB_COLUMN_DATA = "data";
	public static String SIMPLEDB_COLUMN_RECORD_TIME = "recordTime";
    
    public static String dynaDBTableUsersTableName = "users";
    public static String dynaDBTableUsersInfoTableName = "usersInfo";
    public static String dynaDBTableDevicesTableName = "devices";
    public static String dynaDBTableUserDevicesTableName = "userDevices";
    public static String dynaDBTableServiceAdaptorsTableName = "serviceAdaptors";
    public static String dynaDBTableActionRulesTableName = "actionRules";
    public static String dynaDBTableUserActionRulesTableName = "userActionRules";



    public static String TABLE_USERS_USERID_KEY = "userID";
    public static String TABLE_USERS_PASSWORD = "password";
    public static String TABLE_USERS_UUID = "uuid";
	
    public static String TABLE_DEVICES_DEVICEID_KEY = "deviceID";
    public static String TABLE_DEVICES_DEVICE_UUID = "uuid";
    
    public static String TABLE_USER_DEVICES_USER_UUID_KEY = "uuid";
    public static String TABLE_USER_DEVICES_DEVICE_UUID = "deviceUUID";
    public static String TABLE_USER_DEVICES_ACCESSTOKEN = "accesstoken";

    
    public static String TABLE_SERVICE_ADAPTORS_ADAPTOR_KEY = "adaptorID";
    public static String TABLE_SERVICE_ADAPTORS_ADAPTOR_UUID = "uuid";
    public static String TABLE_SERVICE_ADAPTORS_ADAPTOR_NAME = "name";
    public static String TABLE_SERVICE_ADAPTORS_BINDING_URL = "binding_url";
    public static String TABLE_SERVICE_ADAPTORS_CREDENTIAL = "credential";
    
    public static String TABLE_ACTION_RULES_RULE_KEY = "uuid";

    
    //OAuth 1.0
    public static final String OAUTH_TIMESTAMP = "oauth_timestamp";
    public static final String OAUTH_SIGN_METHOD = "oauth_signature_method";
    public static final String OAUTH_SIGNATURE = "oauth_signature";
    public static final String OAUTH_CONSUMER_SECRET = "oauth_consumer_secret";
    public static final String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
    public static final String OAUTH_CALLBACK = "oauth_callback";
    public static final String OAUTH_VERSION = "oauth_version";
    public static final String OAUTH_NONCE = "oauth_nonce";
    public static final String OAUTH_REALM = "realm";
    public static final String OAUTH_PARAM_PREFIX = "oauth_";
    public static final String OAUTH_TOKEN = "oauth_token";
    public static final String OAUTH_TOKEN_SECRET = "oauth_token_secret";
    public static final String OAUTH_OUT_OF_BAND = "oob";
    public static final String OAUTH_VERIFIER = "oauth_verifier";
    public static final String OAUTH_HEADER = "Authorization";
    public static final String OAUTH_SCOPE = "scope";

    //OAuth 2.0
    public static final String OAUTH_ACCESS_TOKEN = "token";
    public static final String OAUTH_CLIENT_ID = "client_id";
    public static final String OAUTH_CLIENT_SECRET = "client_secret";
    public static final String OAUTH_REDIRECT_URI = "redirect_uri";
    public static final String OAUTH_STATE = "state";
    public static final String OAUTH_CODE = "code";
    public static final String OAUTH_GRANT_TYPE = "grant_type";
    public static final String OAUTH_AUTHORIZATION_CODE = "authorization_code";
    public static final String OAUTH_EXPIRES_IN = "expires_in";
    public static final String OAUTH_TOKEN_TYPE = "token_type";

    public static String ADAPTOR_INFO_RESULT = "result";
    public static String ADAPTOR_INFO_HREFURL = "hrefUrl";

    //Adaptor URI
    public static final String OAUTH_AUTHORIZATION_CODE_REDIRECT_URI = "http://localhost:8080/DeviceCloud/servcieadaptors/accesstoken";
    public static final String ADAPTOR_ENTRY_POINT_URI = "api/entrypoint";

    public static String RESPONSE_RESULT = "result";
    
    public static String USER_TOKEN = "token";
    
    public static String DYNAMODB_LOCATION = "dynamodb_location";


}
