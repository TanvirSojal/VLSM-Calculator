### VLSM Calculator

##### A Spring Boot application to handle calculation of IP allocation requests using Variable Length Subnet Masking.

##### version 1.1
VLSM or Variable Length Subnet Masking is a process of allocating subnet masks where the length is not restricted by IP classes. It allows subdividing a subnet for more optimal usage and less IP wastage. 

This app helps user calculate optimal subnet allocation. The process of using it as follows:

1. Enter the Network ID your ISP has provided you in <code>(a.b.c.d/mask)</code> format, which is known as CIDR format.
2. Enter the Host Group information <code>(Name and Size)</code>. For example:
   1. Home Office (10 devices)
   2. Kitchen (4 devices)
   3. Basement (8 devices)
3. Click <code>Calculate Subnect Allocation</code> button to get the allocation result in terms of <code>{network ID, gateway address, broadcast address}</code> for every group.

##### updates of 1.1
1. GNS3 Topology integration implemented. Now you can:
   1. Upload gns3 project file(s) and the host groups from there will be calculated automatically for you.
   2. The host groups will be identified by their interface with router in this format <code>Name1_port_Name1_port</code>. For example: <code>Router1_0_Switch2_1</code>
   3. You can upload multiple gns3 files, and allocate all at once.
   4. You can add more host groups manually.
