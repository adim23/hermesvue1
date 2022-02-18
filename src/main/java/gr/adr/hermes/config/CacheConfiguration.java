package gr.adr.hermes.config;

import java.time.Duration;
import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;
import org.hibernate.cache.jcache.ConfigSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.*;
import tech.jhipster.config.JHipsterProperties;
import tech.jhipster.config.cache.PrefixedKeyGenerator;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private GitProperties gitProperties;
    private BuildProperties buildProperties;
    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache = jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration =
            Eh107Configuration.fromEhcacheCacheConfiguration(
                CacheConfigurationBuilder
                    .newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                    .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                    .build()
            );
    }

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(javax.cache.CacheManager cacheManager) {
        return hibernateProperties -> hibernateProperties.put(ConfigSettings.CACHE_MANAGER, cacheManager);
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            createCache(cm, gr.adr.hermes.repository.UserRepository.USERS_BY_LOGIN_CACHE);
            createCache(cm, gr.adr.hermes.repository.UserRepository.USERS_BY_EMAIL_CACHE);
            createCache(cm, gr.adr.hermes.domain.User.class.getName());
            createCache(cm, gr.adr.hermes.domain.Authority.class.getName());
            createCache(cm, gr.adr.hermes.domain.User.class.getName() + ".authorities");
            createCache(cm, gr.adr.hermes.domain.Jobs.class.getName());
            createCache(cm, gr.adr.hermes.domain.Countries.class.getName());
            createCache(cm, gr.adr.hermes.domain.Regions.class.getName());
            createCache(cm, gr.adr.hermes.domain.Cities.class.getName());
            createCache(cm, gr.adr.hermes.domain.ZipCodes.class.getName());
            createCache(cm, gr.adr.hermes.domain.Addresses.class.getName());
            createCache(cm, gr.adr.hermes.domain.Phones.class.getName());
            createCache(cm, gr.adr.hermes.domain.Emails.class.getName());
            createCache(cm, gr.adr.hermes.domain.PhoneTypes.class.getName());
            createCache(cm, gr.adr.hermes.domain.ContactTypes.class.getName());
            createCache(cm, gr.adr.hermes.domain.SocialKinds.class.getName());
            createCache(cm, gr.adr.hermes.domain.SocialContacts.class.getName());
            createCache(cm, gr.adr.hermes.domain.CompanyKinds.class.getName());
            createCache(cm, gr.adr.hermes.domain.Companies.class.getName());
            createCache(cm, gr.adr.hermes.domain.Companies.class.getName() + ".phones");
            createCache(cm, gr.adr.hermes.domain.Companies.class.getName() + ".addresses");
            createCache(cm, gr.adr.hermes.domain.Codes.class.getName());
            createCache(cm, gr.adr.hermes.domain.Teams.class.getName());
            createCache(cm, gr.adr.hermes.domain.Origins.class.getName());
            createCache(cm, gr.adr.hermes.domain.CitizenFolders.class.getName());
            createCache(cm, gr.adr.hermes.domain.MaritalStatus.class.getName());
            createCache(cm, gr.adr.hermes.domain.Citizens.class.getName());
            createCache(cm, gr.adr.hermes.domain.Citizens.class.getName() + ".phones");
            createCache(cm, gr.adr.hermes.domain.Citizens.class.getName() + ".addresses");
            createCache(cm, gr.adr.hermes.domain.Citizens.class.getName() + ".socials");
            createCache(cm, gr.adr.hermes.domain.Citizens.class.getName() + ".emails");
            createCache(cm, gr.adr.hermes.domain.Citizens.class.getName() + ".relations");
            createCache(cm, gr.adr.hermes.domain.CitizensRelations.class.getName());
            createCache(cm, gr.adr.hermes.domain.CitizensMeetings.class.getName());
            // jhipster-needle-ehcache-add-entry
        };
    }

    private void createCache(javax.cache.CacheManager cm, String cacheName) {
        javax.cache.Cache<Object, Object> cache = cm.getCache(cacheName);
        if (cache != null) {
            cache.clear();
        } else {
            cm.createCache(cacheName, jcacheConfiguration);
        }
    }

    @Autowired(required = false)
    public void setGitProperties(GitProperties gitProperties) {
        this.gitProperties = gitProperties;
    }

    @Autowired(required = false)
    public void setBuildProperties(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new PrefixedKeyGenerator(this.gitProperties, this.buildProperties);
    }
}
