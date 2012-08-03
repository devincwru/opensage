# Grab the architecture name (generated by the configure script)

include $(SAGEROOT)/config/arch

# Set default BUILD to DEBUG:

BUILD = DEBUG

# Grab the various directories required:

INSTALL_DIR = $(SAGEROOT)/../release/$(ARCH)
BASE_DIR    = $(shell cd $(SAGEROOT); pwd)
OFFSET_DIR  = $(shell pwd | sed -e "s,$(BASE_DIR)/,,")
PREV_DIR    = $(shell cd ..; pwd)
CURRENT_DIR = $(shell pwd | sed -e "s,$(PREV_DIR)/,,")
TARGET_BASE = $(SAGEROOT)/targets/$(ARCH)

ifeq ($(TARGET_BASE),)

blow_up:
	@echo No target directory.  Please Configure before running make

endif

TARGET_DIR = $(TARGET_BASE)/$(OFFSET_DIR)
BUILDDIR   = $(TARGET_DIR)

# Get architecture-specific options:

include $(SAGEROOT)/config/$(ARCH)/Global.make

# Set up macros for library includes:

LIB_EXT_APIS      = $(XMLPP) $(PYTHON) $(LAPACK) -lm -lboost_regex $(LIB_PLATSPEC)
LIB_CORE          = -lnumerics -lfortran -lLSF  -lerror $(LIB_EXT_APIS)
LIB_TOOLS         = -lapp -loutput -lutil $(LIB_CORE)
LIB_PEDIGREE_DATA = -lpairs -lrped -lmlocus -lmped $(LIB_TOOLS)
LIB_DATA_CLEANING = -ldata -lgelim -lsampling -lfunc -lfped $(LIB_PEDIGREE_DATA)
LIB_PEDIGREE_ALGS = -libd -lmcmc -llvec $(LIB_DATA_CLEANING)
LIB_ALGORITHMS    = -lmaxfun $(LIB_PEDIGREE_ALGS)
LIB_APIS          = -lmfsubmodels -lmaxfunapi $(LIB_ALGORITHMS)
LIB_ALL           = $(LIB_APIS)

# Set architecture-independent options:

RELEASE.CFLAGS   := $(RELEASE.CFLAGS) -DSAGE_LICENSED
RELEASE.CXXFLAGS := $(RELEASE.CXXFLAGS) -DSAGE_LICENSED

# Define release version (see $(SAGEROOT)/c++/app/Licenser.cpp for implementation details)

MAIN_VERSION  = 6
SUB_VERSION   = 3
MICRO_VERSION = 0
BETA_VERSION  = 0

CXXFLAGS := $(CXXFLAGS) -DSAGE_MAIN_VERSION=$(MAIN_VERSION) -DSAGE_SUB_VERSION=$(SUB_VERSION) -DSAGE_MICRO_VERSION=$(MICRO_VERSION) -DSAGE_BETA_VERSION=$(BETA_VERSION)

# Add autotrace declaration:

ifeq ($(AUTOTRACE), ON)
	CXXFLAGS := $(CXXFLAGS) -DAUTOTRACE_ON
endif
