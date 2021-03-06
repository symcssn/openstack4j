package org.openstack4j.openstack.identity.domain.v3;

import java.util.List;
import java.util.Map;

import org.openstack4j.model.identity.builder.v3.GroupBuilder;
import org.openstack4j.model.identity.v3.Group;
import org.openstack4j.openstack.common.ListResult;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * group model class for identity.v3
 * 
 * @see <a href="http://developer.openstack.org/api-ref-identity-v3.html#groups-v3">API reference</a>
 */
public class KeystoneGroup implements Group {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String description;
    private Map<String, String> links;
    private String domainId;

    /**
     * @return the group buiilder
     */
    public static GroupBuilder builder() {
        return new GroupConcreteBuilder();
    }

    @Override
    public GroupBuilder toBuilder() {
        return new GroupConcreteBuilder(this);
    }

    /**
     * @return the id of the group
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name of the group
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description of the group
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the domainId of the group
     */
    public String getDomainId() {
        return domainId;
    }

    /**
     * @return the links of the group
     */
    public Map<String, String> getLinks() {
        return links;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return Objects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("name", name)
                .add("description", description)
                .add("links", links)
                .add("domainId", domainId)
                .toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, description, links, domainId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        KeystoneGroup that = KeystoneGroup.class.cast(obj);
        return Objects.equal(this.id, that.id)
                && Objects.equal(this.domainId, that.domainId)
                && Objects.equal(this.description, that.description)
                && Objects.equal(this.name, that.name)
                && Objects.equal(this.links, that.links);
    }

    public static class GroupConcreteBuilder implements GroupBuilder {

        KeystoneGroup model;

        GroupConcreteBuilder() {
            this(new KeystoneGroup());
        }

        GroupConcreteBuilder(KeystoneGroup model) {
            this.model = model;
        }

        @Override
        public Group build() {
            return model;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public GroupBuilder from(Group in) {
            if (in != null)
                this.model = (KeystoneGroup) in;
            return this;
        }

        /**
         * @see KeystoneGroup#getId()
         */
        @Override
        public GroupBuilder id(String id) {
            model.id = id;
            return this;
        }

        /**
         * @see KeystoneGroup#getName()
         */
        @Override
        public GroupBuilder name(String name) {
            model.name = name;
            return this;
        }

        /**
         * @see KeystoneGroup#getDescription()()
         */
        @Override
        public GroupBuilder description(String description) {
            model.description = description;
            return this;
        }

        /**
         * @see KeystoneGroup#getDomainId()
         */
        @Override
        public GroupBuilder domainId(String domainId) {
            model.domainId = domainId;
            return this;
        }

        /**
         * @see KeystoneGroup#getLinks()
         */
        @Override
        public GroupBuilder links(Map<String, String> links) {
            model.links = links;
            return this;
        }
    }

    public static class Groups extends ListResult<KeystoneGroup> {

        private static final long serialVersionUID = 1L;
        @JsonProperty("groups")
        protected List<KeystoneGroup> list;

        public List<KeystoneGroup> value() {
            return list;
        }

        public List<KeystoneGroup> all() {
            return list;
        }

        public KeystoneGroup findById(String groupId) {
            return null;
        }
    }

}
