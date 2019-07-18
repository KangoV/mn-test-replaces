package org.belldj;

import java.util.Map;
import java.util.Optional;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micronaut.configuration.security.ldap.group.DefaultLdapGroupProcessor;
import io.micronaut.context.annotation.Replaces;

@Replaces(DefaultLdapGroupProcessor.class)
@Singleton
public class LdapGroupMapper extends DefaultLdapGroupProcessor {

    private static final Logger log = LoggerFactory.getLogger(LdapGroupMapper.class);
    private static final Map<String, String> LDAP_TO_ROLE = Map.of("Mathematicians", "Mathematicians-Modified");

    @Override
    public Optional<String> processGroup(final String group) {
      log.debug("Attempting to map ldap role: {}", group);
      final var opt = Optional.ofNullable(LDAP_TO_ROLE.get(group));
      if (opt.isEmpty()) {
        log.debug("No mapping for ldap group: {}", group);
      } else {
        log.debug("Mapped ldap group {} onto role: {}", group, opt.get());
      }
      return opt;
    }

}