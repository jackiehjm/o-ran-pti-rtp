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

FILESEXTRAPATHS_append:= ":${THISDIR}/linux:"

SRC_URI_append_poky-stx = " file://stx-kconfig.cfg"
SRC_URI_append_anaconda = " file://stx-anaconda-kconfig.cfg"

KERNEL_EXTRA_FEATURES_append = " \
    features/xfs/xfs.scc \
    features/iommu/iommu.scc \
    features/vfio/vfio.scc \
    cfg/debug/sched/debug-sched.scc \
    "
