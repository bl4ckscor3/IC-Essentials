package net.igneouscraft.plugin.icessentials;

/**
 * Contains methods used in the help for each command
 * @author bl4ckscor3
 */
public interface ICommandHelp
{
	/**
	 * @return The syntax of this command. <> = required - [] = optional - | = seperating different available options
	 */
	public abstract String getSyntax();
}
