package hudson.plugins.createjobadvanced;

import hudson.security.Permission;

import java.util.HashSet;
import java.util.Set;

import org.kohsuke.stapler.DataBoundConstructor;

public class DynamicPermissionConfig {
	private String groupFormat;

	private Set<String> checkedPermissionIds = new HashSet<String>();
        
        private Boolean toUpperCase;
        
        private Boolean toLowerCase;

	@DataBoundConstructor
	public DynamicPermissionConfig(String groupFormat, Boolean toUpperCase, Boolean toLowerCase, Set<String> checkedPermissionIds) {
		this.groupFormat = groupFormat;
                this.toUpperCase = toUpperCase;
                this.toLowerCase = toLowerCase;
		if (checkedPermissionIds != null) {
			this.checkedPermissionIds = checkedPermissionIds;
		}
	}

	public void addPermissionId(String permissionId) {
		checkedPermissionIds.add(permissionId);
	}

	/**
	 * @return the groupFormat
	 */
	public String getGroupFormat() {
		return groupFormat;
	}

        /**
	 * @return the toLowerCase
	 */
        public Boolean getToLowerCase() {
            return toLowerCase;
        }

        /**
	 * @return the toUpperCase
	 */
        public Boolean getToUpperCase() {
            return toUpperCase;
        }

	/**
	 * @return the checkedPermissionIds
	 */
	public Set<String> getCheckedPermissionIds() {
		return checkedPermissionIds;
	}

	public boolean isPermissionChecked(Permission permission) {
		return checkedPermissionIds.contains(permission.getId());
	}

	@Override
	public String toString() {
		return "[DynamicPermissionConfig: " + groupFormat + ", toUpperCase: " + toUpperCase + ", toLowerCase: " + toLowerCase + ", permissions: " + checkedPermissionIds + "]";
	}
}
