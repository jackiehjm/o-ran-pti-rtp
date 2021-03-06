#
## Copyright (C) 2019 Wind River Systems, Inc.
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
	file://0900-inject-milisec-in-syslog-date.patch \
	file://0001-systemd-remove-the-log-about-var-run.patch \
	"

STX_DEFAULT_LOCALE ?= "en_US.UTF-8"

do_install_append () {
	install -d ${D}${sysconfdir}
	echo LANG=${STX_DEFAULT_LOCALE} >> ${D}${sysconfdir}/locale.conf
}

FILES_${PN} += "${sysconfdir}/locale.conf"
