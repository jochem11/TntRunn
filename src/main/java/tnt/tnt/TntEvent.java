package tnt.tnt;



import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TntEvent implements Listener {

    private Cuboid cuboid = new Cuboid(
            new Location(Bukkit.getWorld("world"), 785,134,-52),
            new Location(Bukkit.getWorld("world"), 833,70 ,-100)
    );

    public TntEvent() {
        Tnt.getTnt().getServer().getPluginManager().registerEvents(this, Tnt.getTnt());
    }

    @EventHandler//blokken onder je weg halen
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Location location = player.getLocation();

        int y = (int) (location.getY());
        int ysec = (int) location.getY() - 1;
        double x =  location.getX();
        double z =  location.getZ();
        int xint = (int) location.getX();
        int zint = (int) location.getZ();
        World world = player.getWorld();

        Block block = new Location(world, x, ysec, z).getBlock().getRelative(BlockFace.DOWN);
        Block blockSand = new Location(world, x, y, z).getBlock().getRelative(BlockFace.DOWN);
        Block blockGravel = new Location(world, x, y, z).getBlock().getRelative(BlockFace.DOWN);
        Block blockSandLeft = new Location(world, x-1, y, z).getBlock().getRelative(BlockFace.DOWN);
        Block blockTntLeft = new Location(world, x-1, ysec, z).getBlock().getRelative(BlockFace.DOWN);
        Block blockSandRight = new Location(world, x+1, y, z).getBlock().getRelative(BlockFace.DOWN);
        Block blockTntRight = new Location(world, x+1, ysec, z).getBlock().getRelative(BlockFace.DOWN);
        Block blockSandVoor = new Location(world, x, y, z-1).getBlock().getRelative(BlockFace.DOWN);
        Block blockTntVoor = new Location(world, x, ysec, z-1).getBlock().getRelative(BlockFace.DOWN);
        Block blockSandAchter = new Location(world, x, y, z+1).getBlock().getRelative(BlockFace.DOWN);
        Block blockTntAchter = new Location(world, x, ysec, z+1).getBlock().getRelative(BlockFace.DOWN);
        Block blockSandSchuin1 = new Location(world, x-1, y, z-1).getBlock().getRelative(BlockFace.DOWN);
        Block blockTntSchuin1 = new Location(world, x-1, ysec, z-1).getBlock().getRelative(BlockFace.DOWN);
        Block blockSandSchuin2 = new Location(world, x+1, y, z+1).getBlock().getRelative(BlockFace.DOWN);
        Block blockTntSchuin2 = new Location(world, x+1, ysec, z+1).getBlock().getRelative(BlockFace.DOWN);
        Block blockSandSchuin3 = new Location(world, x-1, y, z+1).getBlock().getRelative(BlockFace.DOWN);
        Block blockTntSchuin3 = new Location(world, x-1, ysec, z+1).getBlock().getRelative(BlockFace.DOWN);
        Block blockSandSchuin4 = new Location(world, x+1, y, z-1).getBlock().getRelative(BlockFace.DOWN);
        Block blockTntSchuin4 = new Location(world, x+1, ysec, z-1).getBlock().getRelative(BlockFace.DOWN);


        if (Tnt.getTnt().getToggle()) {
            if (cuboid.contains(location)) {
                if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND) {//sand
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {//delay ding
                        @Override
                        public void run() {
                            blockSand.setType(Material.AIR);
                            block.setType(Material.AIR);

                        }

                    }, 5L);//delay zelf

                }if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.GRAVEL) {//gravel
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                        @Override
                        public void run() {
                            blockGravel.setType(Material.AIR);
                            block.setType(Material.AIR);
                        }//delay ding

                    }, 5L);//delay zelf
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint < 0.4999) {
                        if (y == 120) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandLeft.setType(Material.AIR);
                                    blockTntLeft.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint > 0.5001) {
                        if (y == 120) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandRight.setType(Material.AIR);
                                    blockTntRight.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (z - zint < 0.4999) {
                        if (y == 120) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandVoor.setType(Material.AIR);
                                    blockTntVoor.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (z - zint > 0.5001) {
                        if (y == 120) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandAchter.setType(Material.AIR);
                                    blockTntAchter.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint < 0.4999 && z - zint < 0.4999) {
                        if (y == 120) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin1.setType(Material.AIR);
                                    blockTntSchuin1.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint > 0.5001 && z - zint > 0.5001) {
                        if (y == 120) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin2.setType(Material.AIR);
                                    blockTntSchuin2.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint < 0.4999 && z - zint > 0.5001) {
                        if (y == 120) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin3.setType(Material.AIR);
                                    blockTntSchuin3.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint > 0.5001 && z - zint < 0.4999) {
                        if (y == 120) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin4.setType(Material.AIR);
                                    blockTntSchuin4.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint < 0.4999) {
                        if (y == 109) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandLeft.setType(Material.AIR);
                                    blockTntLeft.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint > 0.5001) {
                        if (y == 109) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandRight.setType(Material.AIR);
                                    blockTntRight.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (z - zint < 0.4999) {
                        if (y == 109) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandVoor.setType(Material.AIR);
                                    blockTntVoor.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (z - zint > 0.5001) {
                        if (y == 109) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandAchter.setType(Material.AIR);
                                    blockTntAchter.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint < 0.4999 && z - zint < 0.4999) {
                        if (y == 109) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin1.setType(Material.AIR);
                                    blockTntSchuin1.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint > 0.5001 && z - zint > 0.5001) {
                        if (y == 109) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin2.setType(Material.AIR);
                                    blockTntSchuin2.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint < 0.4999 && z - zint > 0.5001) {
                        if (y == 109) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin3.setType(Material.AIR);
                                    blockTntSchuin3.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint > 0.5001 && z - zint < 0.4999) {
                        if (y == 109) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin4.setType(Material.AIR);
                                    blockTntSchuin4.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint < 0.4999) {
                        if (y == 96) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandLeft.setType(Material.AIR);
                                    blockTntLeft.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint > 0.5001) {
                        if (y == 96) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandRight.setType(Material.AIR);
                                    blockTntRight.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (z - zint < 0.4999) {
                        if (y == 96) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandVoor.setType(Material.AIR);
                                    blockTntVoor.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (z - zint > 0.5001) {
                        if (y == 96) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandAchter.setType(Material.AIR);
                                    blockTntAchter.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint < 0.4999 && z - zint < 0.4999) {
                        if (y == 96) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin1.setType(Material.AIR);
                                    blockTntSchuin1.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint > 0.5001 && z - zint > 0.5001) {
                        if (y == 96) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin2.setType(Material.AIR);
                                    blockTntSchuin2.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint < 0.4999 && z - zint > 0.5001) {
                        if (y == 96) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin3.setType(Material.AIR);
                                    blockTntSchuin3.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint > 0.5001 && z - zint < 0.4999) {
                        if (y == 96) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin4.setType(Material.AIR);
                                    blockTntSchuin4.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint < 0.4999) {
                        if (y == 84) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandLeft.setType(Material.AIR);
                                    blockTntLeft.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint > 0.5001) {
                        if (y == 84) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandRight.setType(Material.AIR);
                                    blockTntRight.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (z - zint < 0.4999) {
                        if (y == 84) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandVoor.setType(Material.AIR);
                                    blockTntVoor.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (z - zint > 0.5001) {
                        if (y == 84) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandAchter.setType(Material.AIR);
                                    blockTntAchter.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint < 0.4999 && z - zint < 0.4999) {
                        if (y == 84) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin1.setType(Material.AIR);
                                    blockTntSchuin1.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint > 0.5001 && z - zint > 0.5001) {
                        if (y == 84) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin2.setType(Material.AIR);
                                    blockTntSchuin2.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint < 0.4999 && z - zint > 0.5001) {
                        if (y == 84) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin3.setType(Material.AIR);
                                    blockTntSchuin3.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                } if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                    if (x - xint > 0.5001 && z - zint < 0.4999) {
                        if (y == 84) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt(), new Runnable() {
                                @Override
                                public void run() {
                                    blockSandSchuin4.setType(Material.AIR);
                                    blockTntSchuin4.setType(Material.AIR);
                                }//delay ding

                            }, 5L);//delay zelf
                        }
                    }
                }
            }


        }//einde blokken weghalen
    }
}
