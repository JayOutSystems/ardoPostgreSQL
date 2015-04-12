#!/bin/bash

# NOTE: In a farm this needs to be executed in all frontends and the controller.

source /etc/sysconfig/outsystems

umask 022

# this is for jboss 7 / jboss 6 eap.

mkdir -p $JBOSS_HOME/modules/outsystems/ardopgsql/
cp postgresql-9.4-1201.jdbc4.jar module.xml $JBOSS_HOME/modules/outsystems/ardopgsql/
cp ardo.databaseprovider.postgresql.jar $OUTSYSTEMS_HOME/plugins/database
cp postgresql-9.4-1201.jdbc4.jar $OUTSYSTEMS_HOME/lib

chown -R jboss:jboss $JBOSS_HOME/modules/outsystems/ardopgsql/
chown outsystems:outsystems $OUTSYSTEMS_HOME/plugins/database/ardo.databaseprovider.postgresql.jar
chown outsystems:outsystems $OUTSYSTEMS_HOME/lib/postgresql-9.4-1201.jdbc4.jar

$JBOSS_HOME/bin/jboss-cli.sh -c --command='/subsystem=ee:write-attribute(name=global-modules, value=[{"name" => "outsystems", "slot" => "main"},{"name" => "outsystems", "slot" => "ardopgsql"}])'

source /etc/outsystems/os.services.conf

if [ $CONTROLLER = ENABLED ]; then 
	$OUTSYSTEMS_HOME/configurationtool.sh /upgradeinstall /silent /scinstall
else
	service jboss-outsystems restart
	echo Don\'t forget to run this on all front-ends and also on the Controller
fi
