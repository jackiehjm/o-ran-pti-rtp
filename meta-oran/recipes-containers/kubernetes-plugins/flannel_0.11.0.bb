#
# Copyright (C) 2019 Wind River Systems, Inc.
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

SUMMARY = "Flannel is a simple and easy way to configure a layer 3 network fabric designed for Kubernetes."
DESCRIPTION = "\
  Flannel runs a small, single binary agent called flanneld on each host, \
  and is responsible for allocating a subnet lease to each host out of a \
  larger, preconfigured address space. Flannel uses either the Kubernetes \
  API or etcd directly to store the network configuration, the allocated \
  subnets, and any auxiliary data (such as the host's public IP). Packets \
  are forwarded using one of several backend mechanisms including VXLAN and \
  various cloud integrations. \
"
HOMEPAGE = "https://github.com/coreos/flannel"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "\
    https://github.com/coreos/flannel/archive/v${PV}.tar.gz;downloadfilename=${BPN}-v${PV}.tar.gz \
"

SRC_URI[md5sum] = "e023f76c688fd74dce6c0c8df8bea5d7"
SRC_URI[sha256sum] = "476c886ddc06a8afcf54e181ac55579224c6be424089567a0b8d9e93dd08a053"

S = "${WORKDIR}/${BPN}-${PV}"

K8S_PLUGINS = "${sysconfdir}/kubernetes/plugins/${BPN}"

do_install() {
    install -d ${D}${K8S_PLUGINS}
    install -m 644 ${S}/README.md ${D}${K8S_PLUGINS}
    install -m 644 ${S}/Documentation/kube-flannel.yml ${D}${K8S_PLUGINS}
    sed -i -e 's/v0.10.0/v0.11.0/' ${D}${K8S_PLUGINS}/kube-flannel.yml
}
