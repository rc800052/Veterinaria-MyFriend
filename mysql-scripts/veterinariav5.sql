SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `clinicaveterinaria` DEFAULT CHARACTER SET latin1 ;
USE `clinicaveterinaria` ;

-- -----------------------------------------------------
-- Table `clinicaveterinaria`.`prospecto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `clinicaveterinaria`.`prospecto` (
  `idProspecto` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(255) NOT NULL ,
  `email` VARCHAR(255) NOT NULL ,
  `direccion` VARCHAR(255) NOT NULL ,
  `imagen` VARCHAR(255) NULL DEFAULT NULL ,
  `telcasa` VARCHAR(255) NULL DEFAULT NULL ,
  `telcelular` VARCHAR(255) NULL DEFAULT NULL ,
  `cliente` CHAR(1) NULL DEFAULT NULL ,
  PRIMARY KEY (`idProspecto`) )
ENGINE = InnoDB

DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `clinicaveterinaria`.`cliente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `clinicaveterinaria`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(255) NOT NULL ,
  `email` VARCHAR(255) NOT NULL ,
  `direccion` VARCHAR(255) NOT NULL ,
  `imagen` VARCHAR(255) NOT NULL ,
  `telcasa` VARCHAR(255) NOT NULL ,
  `telcelular` VARCHAR(255) NOT NULL ,
  `notas` VARCHAR(255) NULL DEFAULT NULL ,
  `idProspecto` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`idCliente`) ,
  INDEX `fk_Cliente_Prospecto1` (`idProspecto` ASC) ,
  CONSTRAINT `fk_Cliente_Prospecto1`
    FOREIGN KEY (`idProspecto` )
    REFERENCES `clinicaveterinaria`.`prospecto` (`idProspecto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `clinicaveterinaria`.`doctor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `clinicaveterinaria`.`doctor` (
  `idDoctor` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  `apellido` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `telefono` VARCHAR(45) NOT NULL ,
  `usuario` VARCHAR(45) NOT NULL ,
  `clave` VARCHAR(45) NOT NULL ,
  `perfil` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idDoctor`) )
ENGINE = InnoDB

DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `clinicaveterinaria`.`paciente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `clinicaveterinaria`.`paciente` (
  `idPaciente` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(255) NOT NULL ,
  `esterilizado` CHAR(1) NOT NULL ,
  `tamaño` VARCHAR(255) NOT NULL ,
  `actividad` VARCHAR(255) NOT NULL ,
  `peso` DOUBLE NOT NULL ,
  `fchnac` VARCHAR(100) NOT NULL ,
  `especie` VARCHAR(255) NOT NULL ,
  `raza` VARCHAR(255) NOT NULL ,
  `genero` VARCHAR(255) NOT NULL ,
  `tiposangre` VARCHAR(255) NOT NULL ,
  `idCliente` INT(11) NOT NULL ,
  PRIMARY KEY (`idPaciente`) ,
  INDEX `fk_Paciente_Cliente1` (`idCliente` ASC) ,
  CONSTRAINT `fk_Paciente_Cliente1`
    FOREIGN KEY (`idCliente` )
    REFERENCES `clinicaveterinaria`.`cliente` (`idCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `clinicaveterinaria`.`cita`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `clinicaveterinaria`.`cita` (
  `idCita` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NOT NULL ,
  `telefono` VARCHAR(45) NOT NULL ,
  `direccion` VARCHAR(45) NOT NULL ,
  `fchcita` DATETIME NOT NULL ,
  `estado` VARCHAR(45) NOT NULL ,
  `idDoctor` INT(11) NOT NULL ,
  `idPaciente` INT(11) NOT NULL ,
  `idCliente` INT(11) NOT NULL ,
  PRIMARY KEY (`idCita`) ,
  INDEX `fk_Cita_Doctor1` (`idDoctor` ASC) ,
  INDEX `fk_Cita_Paciente1` (`idPaciente` ASC) ,
  INDEX `fk_Cita_Cliente1` (`idCliente` ASC) ,
  CONSTRAINT `fk_Cita_Cliente1`
    FOREIGN KEY (`idCliente` )
    REFERENCES `clinicaveterinaria`.`cliente` (`idCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cita_Doctor1`
    FOREIGN KEY (`idDoctor` )
    REFERENCES `clinicaveterinaria`.`doctor` (`idDoctor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cita_Paciente1`
    FOREIGN KEY (`idPaciente` )
    REFERENCES `clinicaveterinaria`.`paciente` (`idPaciente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `clinicaveterinaria`.`tipoproducto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `clinicaveterinaria`.`tipoproducto` (
  `idTipo` INT(11) NOT NULL AUTO_INCREMENT ,
  `tipo` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`idTipo`) )
ENGINE = InnoDB

DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `clinicaveterinaria`.`producto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `clinicaveterinaria`.`producto` (
  `idProducto` INT(11) NOT NULL AUTO_INCREMENT ,
  `producto` VARCHAR(255) NULL DEFAULT NULL ,
  `precio` DOUBLE NULL DEFAULT NULL ,
  `idTipo` INT(11) NOT NULL ,
  PRIMARY KEY (`idProducto`) ,
  INDEX `fk_Producto_TipoProducto1` (`idTipo` ASC) ,
  CONSTRAINT `fk_Producto_TipoProducto1`
    FOREIGN KEY (`idTipo` )
    REFERENCES `clinicaveterinaria`.`tipoproducto` (`idTipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `clinicaveterinaria`.`citadetalle`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `clinicaveterinaria`.`citadetalle` (
  `idCitaDet` INT(11) NOT NULL AUTO_INCREMENT ,
  `cantidad` DOUBLE NOT NULL ,
  `precio` DOUBLE NOT NULL ,
  `idCita` INT(11) NOT NULL ,
  `idProducto` INT(11) NOT NULL ,
  PRIMARY KEY (`idCitaDet`) ,
  INDEX `fk_CitaDetalle_Cita1` (`idCita` ASC) ,
  INDEX `fk_CitaDetalle_Producto1` (`idProducto` ASC) ,
  CONSTRAINT `fk_CitaDetalle_Cita1`
    FOREIGN KEY (`idCita` )
    REFERENCES `clinicaveterinaria`.`cita` (`idCita` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CitaDetalle_Producto1`
    FOREIGN KEY (`idProducto` )
    REFERENCES `clinicaveterinaria`.`producto` (`idProducto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `clinicaveterinaria`.`factura`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `clinicaveterinaria`.`factura` (
  `idFactura` INT(11) NOT NULL AUTO_INCREMENT ,
  `fch_Factura` DATETIME NOT NULL ,
  `serie` VARCHAR(5) NOT NULL ,
  `numero` VARCHAR(10) NOT NULL ,
  `fch_Emision` DATETIME NOT NULL ,
  `moneda` VARCHAR(2) NOT NULL ,
  `tc` DOUBLE NOT NULL ,
  `idCliente` INT(11) NOT NULL ,
  PRIMARY KEY (`idFactura`) ,
  INDEX `fk_Factura_Cliente1` (`idCliente` ASC) ,
  CONSTRAINT `fk_Factura_Cliente1`
    FOREIGN KEY (`idCliente` )
    REFERENCES `clinicaveterinaria`.`cliente` (`idCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `clinicaveterinaria`.`facturadetalle`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `clinicaveterinaria`.`facturadetalle` (
  `idFacturaDetalle` INT(11) NOT NULL AUTO_INCREMENT ,
  `cantidad` DOUBLE NOT NULL ,
  `precio` DOUBLE NOT NULL ,
  `subtotal` DOUBLE NOT NULL ,
  `igv` DOUBLE NOT NULL ,
  `idProducto` INT(11) NOT NULL ,
  `idFactura` INT(11) NOT NULL ,
  PRIMARY KEY (`idFacturaDetalle`) ,
  INDEX `fk_FacturaDetalle_Producto1` (`idProducto` ASC) ,
  INDEX `fk_FacturaDetalle_Factura1` (`idFactura` ASC) ,
  CONSTRAINT `fk_FacturaDetalle_Factura1`
    FOREIGN KEY (`idFactura` )
    REFERENCES `clinicaveterinaria`.`factura` (`idFactura` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FacturaDetalle_Producto1`
    FOREIGN KEY (`idProducto` )
    REFERENCES `clinicaveterinaria`.`producto` (`idProducto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `clinicaveterinaria`.`historia`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `clinicaveterinaria`.`historia` (
  `idHistoria` INT(11) NOT NULL AUTO_INCREMENT ,
  `notaMedica` VARCHAR(45) NULL DEFAULT NULL ,
  `imagenMedica` VARCHAR(45) NULL DEFAULT NULL ,
  `condicionEspecial` VARCHAR(45) NULL DEFAULT NULL ,
  `idCita` INT(11) NOT NULL ,
  PRIMARY KEY (`idHistoria`) ,
  INDEX `fk_Historia_Cita1` (`idCita` ASC) ,
  CONSTRAINT `fk_Historia_Cita1`
    FOREIGN KEY (`idCita` )
    REFERENCES `clinicaveterinaria`.`cita` (`idCita` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
