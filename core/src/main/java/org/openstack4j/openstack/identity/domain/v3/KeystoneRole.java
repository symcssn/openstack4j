package org.openstack4j.openstack.identity.domain.v3;

import java.util.List;
import java.util.Map;

import org.openstack4j.model.identity.builder.v3.RoleBuilder;
import org.openstack4j.model.identity.v3.Role;
import org.openstack4j.openstack.common.ListResult;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * v3 role implementation
 */
public class KeystoneRole implements Role {

    private static final long serialVersionUID = 1L;
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
    private Map<String, String> links;

    @Override
    public RoleBuilder toBuilder() {
        return new RoleConcreteBuilder(this);
    }

    public static RoleBuilder builder() {
        return new RoleConcreteBuilder();
    }

    /**
     * {@inheritDoc}
     */
    public String getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    public Map<String, String> getLinks() {
        return links;
    }

    /**
     * {@inheritDoc}
     */
    public void update() {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    public void destroy() {
        // TODO
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("name", name)
                .add("links", links)
                .toString();
    }

    public static class RoleConcreteBuilder implements RoleBuilder {

        private KeystoneRole model;

        RoleConcreteBuilder() {
            this(new KeystoneRole());
        }

        RoleConcreteBuilder(KeystoneRole model) {
            this.model = model;
        }

        @Override
        public Role build() {
            return model;
        }

        @Override
        public RoleBuilder from(Role in) {
            model = (KeystoneRole) in;
            return this;
        }

        @Override
        public RoleBuilder id(String id) {
            model.id = id;
            return this;
        }

        @Override
        public RoleBuilder name(String name) {
            model.name = name;
            return this;
        }

        @Override
        public RoleBuilder links(Map<String, String> links) {
            model.links = links;
            return this;
        }

    }

    public static class Roles extends ListResult<KeystoneRole> {

        private static final long serialVersionUID = 1L;
        @JsonProperty("roles")
        protected List<KeystoneRole> list;

        public List<KeystoneRole> value() {
            return list;
        }

    }

}
