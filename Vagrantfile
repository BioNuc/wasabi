# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure(2) do |config|
  config.vm.define "wasabi"

  config.vm.box = "ubuntu/xenial64"

  config.vm.network :forwarded_port, host: 8080, guest: 8080

  config.vm.synced_folder '.', '/vagrant'

  config.vm.provider "virtualbox" do |vb|
    vb.memory = "2048"
    vb.cpus = 2
    
    vb.customize ["modifyvm", :id, "--ioapic", "on"]
  end
  
  config.vm.provider "virtualbox" do |v|
    v.customize ["setextradata", :id, "VBoxInternal2/SharedFoldersEnableSymlinksCreate/v-root", "1"]
  end
end