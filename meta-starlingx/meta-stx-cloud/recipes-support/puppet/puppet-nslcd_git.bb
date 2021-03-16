
SUMMARY = "A Puppet module to manage the nslcd daemon which provides authentication via LDAP"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://Modulefile;md5=674f57ad12dfafcf6c3943f34d459ded"

PV = "0.0.1"
SRCREV = "b8c19b1ada89865f2e50758e054583798ad8011a"
PROTOCOL = "https"
BRANCH = "master"
S = "${WORKDIR}/git"

SRC_URI = " \
	git://github.com/jlyheden/puppet-nslcd;protocol=${PROTOCOL};rev=${SRCREV};branch=${BRANCH} \
	file://${PN}/Add-gemspec.patch \
	file://${PN}/metadata.json.patch \
	" 

inherit ruby 

DEPENDS += " \
	ruby \
	facter \
	"

RDEPENDS_${PN} += " \
	ruby \
	facter \
	puppet \
	perl \
	"

RUBY_INSTALL_GEMS = "${PN}-${PV}.gem"

do_install_append() {
	install -d -m 0755 ${D}/${datadir}/puppet/modules/nslcd
	tar -C ${S} -cf - --exclude "patches" --exclude "*.gem*" . | tar --no-same-owner -xf - -C ${D}/${datadir}/puppet/modules/nslcd
}

FILES_${PN} += " ${datadir}"
