/*
 * output_stream_p.java
 *
 * Copyright (C) 2004 Peter Graves
 * $Id: output_stream_p.java,v 1.6 2007/02/23 21:17:36 piso Exp $
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package org.armedbear.lisp;

// ### output-stream-p
public final class output_stream_p extends Primitive
{
    private output_stream_p()
    {
        super("output-stream-p");
    }

    public LispObject execute(LispObject arg) throws ConditionThrowable
    {
        try {
            return ((Stream)arg).isOutputStream() ? T : NIL;
        }
        catch (ClassCastException e) {
            return error(new TypeError(arg, Symbol.STREAM));
        }
    }

    private static final Primitive OUTPUT_STREAM_P = new output_stream_p();
}
