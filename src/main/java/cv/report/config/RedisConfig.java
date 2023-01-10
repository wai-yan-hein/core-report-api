package cv.report.config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Configuration
public class RedisConfig {
   /* @Autowired
    private Environment environment;

    //@Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        String host = Objects.requireNonNull(environment.getProperty("host"));
        int port = Integer.parseInt(Objects.requireNonNull(environment.getProperty("port")));
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(host, port);
        config.setUsername("default");
        config.setPassword(environment.getProperty("password"));
        log.info("jedisConnectionFactory.");
        return new JedisConnectionFactory(config);
    }

   // @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new JdkSerializationRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        template.setEnableTransactionSupport(true);
        template.afterPropertiesSet();
        log.info("redisTemplate.");
        return template;
    }*/
}
