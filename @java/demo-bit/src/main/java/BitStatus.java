/**
 * 位运算的状态控制
 * 
 * @author Administrator
 *
 */
public class BitStatus extends BitBase {

	public static void main(String[] args) {
		// 设定每一位来表示一个状态
		int jsp 		= 1 << 0;
		int html 		= 1 << 1;
		int html_webGL 	= 1 << 2;
		int android 	= 1 << 3;
		int ios 		= 1 << 4;
		int mac 		= 1 << 5;

		out(to8(toBinary(1 << 0))); // 00000001 jsp
		out(to8(toBinary(1 << 1))); // 00000010 html
		out(to8(toBinary(1 << 2))); // 00000100 html_webGL
		out(to8(toBinary(1 << 3))); // 00001000 android
		out(to8(toBinary(1 << 4))); // 00010000 ios
		out(to8(toBinary(1 << 5))); // 00100000 mac

		// 范围组合
		int web = jsp | html | html_webGL;
		out(to8(toBinary(web))); // 00000111 位或( | )

		int mobile = android | ios;
		out(to8(toBinary(mobile))); // 00011000 位或( | )
		
		// 应用,位与&运算后,等于0说明不在范围内,不为0说明在范围内
		out(toBinary(web & html)); 	// 10	 非0,是web
		out(toBinary(web & android)); // 0	 为0,不是web
		out(toBinary(mobile & ios)); 	// 10000 非0,是isMobile
		out(toBinary(mobile & mac)); 	// 0 	 为0,不是isMobile
		
		// 场景:已知状态含有`android`,设置及入库
		int status = android;
		
		// 获得状态(数据库),判断状态是否为android,web,mobile
		boolean isAndroid 	= (status & android) > 0 ? true : false;
		boolean isWeb 		= (status & web) > 0 ? true : false;
		boolean isMobile 	= (status & mobile) > 0 ? true : false;
		
	}
}

/**
 * 示例 [cocos2d-x.org] tests-main.js
 * 
 * @var PLATFORM_JSB = 1 << 0;
 * @var PLATFORM_HTML5 = 1 << 1;
 * @var PLATFORM_HTML5_WEBGL = 1 << 2;
 * @var PLATFROM_ANDROID = 1 << 3;
 * @var PLATFROM_IOS = 1 << 4;
 * @var PLATFORM_MAC = 1 << 5;
 * @var PLATFORM_JSB_AND_WEBGL = PLATFORM_JSB | PLATFORM_HTML5_WEBGL;
 * @var PLATFORM_ALL = PLATFORM_JSB | PLATFORM_HTML5 | PLATFORM_HTML5_WEBGL |
 *      PLATFROM_ANDROID | PLATFROM_IOS;
 * @var PLATFROM_APPLE = PLATFROM_IOS | PLATFORM_MAC;
 */
