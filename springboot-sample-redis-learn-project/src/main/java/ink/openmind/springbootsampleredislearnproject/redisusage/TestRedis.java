package ink.openmind.springbootsampleredislearnproject.redisusage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ink.openmind.springbootsampleredislearnproject.config.RedisConnection;
import redis.clients.jedis.Jedis;

public class TestRedis {
	private static final Jedis jedis = RedisConnection.getJedis();
	public static void main(String[] args) {
		//测试连接： System.out.println(RedisUtil.getJedis().ping());
		// 测试字符串 testString();
		// testMap();
		// testList();
		testSet();
	}
	// Set类型
	public static void testSet() {
		// 添加
		jedis.sadd("user", "Felix");
		jedis.sadd("user", "Demon");
		jedis.sadd("user", "Andy");
		jedis.sadd("user", "Linda");
		// 移除Linda
		jedis.srem("user", "Linda");
		System.out.println(jedis.smembers("user")); // 获取所有的V
		System.out.println(jedis.sismember("user", "Amy")); // 判断一个元素是否是Set之中
		System.out.println(jedis.srandmember("user"));
		System.out.println(jedis.scard("user")); // 返回集合的元素个数
//				[Andy, Demon, Felix]
//				false
//				Demon
//				3
	}
	
	// List类型
	public static void testList() {
		// 开始前，先移除所有内容
		jedis.del("java framework");
		System.out.println(jedis.lrange("java framework", 0, -1));
		// 先向key是java framework中存放三条数据
		jedis.lpush("java framework", "Spring");
		jedis.lpush("java framework", "Spring MVC");
		jedis.lpush("java framework", "Spring Cloud");
		// 取出所有数据jedis.lrange按照范围取出
		// 第一个是key, 第二个是起始位置，第三个是结束位置， jedis.llen获取长度 -1表示取得所有
		System.out.println(jedis.lrange("java framework", 0, -1));
		System.out.println("length: " + jedis.llen("java framework"));
//		[Spring Cloud, Spring MVC, Spring]
//		length: 3
	}
	
	// Map类型
	public static void testMap() {
		// -- 添加数据 --
		Map<String, String> map = new HashMap<String, String>();
		map.put("productName", "iPad-mini5");
		map.put("size", "7.9");
		map.put("price", "3500￥");
		map.put("brand-name", "Apple");
		map.put("made-place", "China");
		jedis.hmset("iPad-mini5 Info", map);
		// hmget()中第一个参数是key
		List<String> ipad_mini5_Info = jedis.hmget("iPad-mini5 Info","productName", "size", "price", "brand-name", "made-place");
		System.out.println(ipad_mini5_Info);//[iPad-mini5, 7.9, 3500￥, Apple, China]
		
		Iterator<String> ite = jedis.hkeys("iPad-mini5 Info").iterator();
		System.out.println("--");
		while(ite.hasNext()) {
			String key = ite.next();
			System.out.println("key: " + key + " value: " + jedis.hmget("iPad-mini5 Info", key));
		}
		System.out.println("--");
		
//				key: brand-name value: [Apple]
//				key: made-place value: [China]
//				key: size value: [7.9]
//				key: price value: [3500￥]
//				key: productName value: [iPad-mini5]
	}
	// 字符串类型
	public static void testString() {
		// -- 添加数据 --
		jedis.set("name", "Java");
		System.out.println(jedis.get("name"));
		
		// -- 拼接 --
		jedis.append("name", " is my lover");
		System.out.println(jedis.get("name")); // Java is my lover

		// -- 删除 --
		jedis.del("name");
		System.out.println(jedis.get("name")); // null
		
		// -- 设置多个键值对 --
		jedis.mset("username", "wangzz", "age", "22", "job", "Java-developer");
		System.out.println("username: " + jedis.get("username") + ", age: " + jedis.get("age") + ", job: " + jedis.get("job"));
	}
	
	// 列表类型
	
}
